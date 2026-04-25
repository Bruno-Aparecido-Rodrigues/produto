package io.github.fatec.controller;

import io.github.fatec.controller.adapter.ProdutoControllerAdapter;
import io.github.fatec.controller.dto.request.ProdutoRequest;
import io.github.fatec.controller.dto.request.ProdutoUpdateRequest;
import io.github.fatec.controller.dto.response.ProdutoResponse;
import io.github.fatec.entity.Produto;
import io.github.fatec.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fatec/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProdutoResponse criar(@RequestBody ProdutoRequest request) {
        Produto produto = ProdutoControllerAdapter.cast(request);
        Produto criado = service.criar(produto);
        return ProdutoControllerAdapter.toResponse(criado);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public ProdutoResponse atualizar(@RequestBody ProdutoUpdateRequest request) {
        Produto produto = ProdutoControllerAdapter.cast(request);
        Produto atualizado = service.atualizar(produto);
        return ProdutoControllerAdapter.toResponse(atualizado);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ProdutoResponse> listar() {
        return service.listar()
                .stream()
                .map(ProdutoControllerAdapter::toResponse)
                .toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ProdutoResponse buscarPorId(@PathVariable String id) {
        Produto produto = service.buscarPorId(id);
        return ProdutoControllerAdapter.toResponse(produto);
    }
}
