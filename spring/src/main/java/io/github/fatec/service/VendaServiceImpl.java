package io.github.fatec.service;

import io.github.fatec.client.ClienteFeignClient;
import io.github.fatec.client.dto.ClienteResponse;
import io.github.fatec.entity.ItemVenda;
import io.github.fatec.entity.Produto;
import io.github.fatec.entity.Venda;
import io.github.fatec.repository.ProdutoRepository;
import io.github.fatec.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendaServiceImpl implements VendaService {

    private final VendaRepository vendaRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteFeignClient clienteFeignClient;

    public VendaServiceImpl(VendaRepository vendaRepository,
                            ProdutoRepository produtoRepository,
                            ClienteFeignClient clienteFeignClient) {
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
        this.clienteFeignClient = clienteFeignClient;
    }

    @Override
    public Venda realizarVenda(Venda venda) {

        // Busca o cliente no serviço de cliente com o feign
        ClienteResponse cliente = clienteFeignClient.buscarPorId(venda.clienteId());
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado: " + venda.clienteId());
        }

        // Enriquece itens com dados atuais do produto e calcula preços
        List<ItemVenda> itensEnriquecidos = venda.itens().stream().map(item -> {
            Produto produto = produtoRepository.buscarPorId(item.produtoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + item.produtoId()));
            return new ItemVenda(
                    produto.id(),
                    produto.nome(),
                    item.quantidade(),
                    produto.preco()
            );
        }).toList();

        // Calcula total da venda
        BigDecimal total = itensEnriquecidos.stream()
                .map(i -> i.precoUnitario().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Gera número sequencial da venda
        int proximoNumero = vendaRepository.listar().size() + 1;

        Venda vendaCompleta = new Venda(
                null,
                proximoNumero,
                cliente.id(),
                cliente.nome(),
                itensEnriquecidos,
                total,
                LocalDateTime.now()
        );

        return vendaRepository.salvar(vendaCompleta);
    }

    @Override
    public List<Venda> listarVendas() {
        return vendaRepository.listar();
    }

    @Override
    public Venda consultarVendaPorNumero(Integer numero) {
        return vendaRepository.buscarPorNumero(numero)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada: " + numero));
    }

    @Override
    public List<Venda> listarComprasPorCliente(String clienteId) {
        return vendaRepository.buscarPorClienteId(clienteId);
    }
}
