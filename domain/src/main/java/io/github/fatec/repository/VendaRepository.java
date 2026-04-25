package io.github.fatec.repository;

import io.github.fatec.entity.Venda;

import java.util.List;
import java.util.Optional;

public interface VendaRepository {

    Venda salvar(Venda venda);

    List<Venda> listar();

    Optional<Venda> buscarPorNumero(Integer numero);

    List<Venda> buscarPorClienteId(String clienteId);
}
