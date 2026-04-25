package io.github.fatec.controller;

import io.github.fatec.controller.adapter.ProdutoControllerAdapter;
import io.github.fatec.controller.dto.request.VendaRequest;
import io.github.fatec.controller.dto.response.VendaResponse;
import io.github.fatec.entity.Venda;
import io.github.fatec.service.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fatec/vendas")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    // POST /fatec/vendas
    // Realiza uma nova venda, gera numerp, busca dados do produto e calcula total
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public VendaResponse realizarVenda(@RequestBody VendaRequest request) {
        Venda venda = ProdutoControllerAdapter.castVenda(request);
        Venda realizada = service.realizarVenda(venda);
        return ProdutoControllerAdapter.toVendaResponse(realizada);
    }

    // GET /fatec/vendas Lista todas as vendas com seus números
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<VendaResponse> listarVendas() {
        return service.listarVendas()
                .stream()
                .map(ProdutoControllerAdapter::toVendaResponse)
                .toList();
    }

    // GET /fatec/vendas/{numero} Consulta uma venda pelo número, retornando itens e total
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{numero}")
    public VendaResponse consultarVendaPorNumero(@PathVariable Integer numero) {
        Venda venda = service.consultarVendaPorNumero(numero);
        return ProdutoControllerAdapter.toVendaResponse(venda);
    }

    //GET /fatec/vendas/cliente/{clienteId} Lista todas as compras de um cliente específico
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cliente/{clienteId}")
    public List<VendaResponse> listarComprasPorCliente(@PathVariable String clienteId) {
        return service.listarComprasPorCliente(clienteId)
                .stream()
                .map(ProdutoControllerAdapter::toVendaResponse)
                .toList();
    }
}
