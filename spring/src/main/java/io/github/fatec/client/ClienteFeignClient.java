package io.github.fatec.client;

import io.github.fatec.client.dto.ClienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente-service", url = "${services.cliente.url}")
public interface ClienteFeignClient {

    @GetMapping("/fatec/clientes/{id}")
    ClienteResponse buscarPorId(@PathVariable("id") String id);
}
