package io.github.fatec.service;

import io.github.fatec.entity.Venda;

import java.util.List;

public interface VendaService {

    Venda realizarVenda(Venda venda);

    List<Venda> listarVendas();

    Venda consultarVendaPorNumero(Integer numero);

    List<Venda> listarComprasPorCliente(String clienteId);
}
