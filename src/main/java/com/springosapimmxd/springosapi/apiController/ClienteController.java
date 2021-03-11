package com.springosapimmxd.springosapi.apiController;

import com.springosapimmxd.springosapi.domain.model.Cliente;
import com.springosapimmxd.springosapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<Cliente> FindById(@PathVariable Long clienteId){
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/clientenome/{clienteNome}")
    public ResponseEntity<Cliente> FindByNome(@PathVariable String clienteNome){
        Optional<Cliente> cliente = clienteRepository.findByNome(clienteNome);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

}
