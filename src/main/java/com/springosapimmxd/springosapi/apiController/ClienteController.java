package com.springosapimmxd.springosapi.apiController;

import com.springosapimmxd.springosapi.domain.model.Cliente;
import com.springosapimmxd.springosapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        return clienteRepository.findAll();

    }
}
