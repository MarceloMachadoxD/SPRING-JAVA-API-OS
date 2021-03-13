package com.springosapimmxd.springosapi.apiController;

import com.springosapimmxd.springosapi.domain.model.Cliente;
import com.springosapimmxd.springosapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
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

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente){

        return  clienteRepository.save(cliente);
    }

    @PutMapping("/cliente/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente){

        if (clienteRepository.existsById(clienteId)) {
            cliente.setId(clienteId);
            cliente =  clienteRepository.save(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/cliente/{clienteId}")
    public ResponseEntity<Cliente> Remover(@PathVariable Long clienteId){
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (cliente.isPresent()){
            clienteRepository.deleteById(clienteId);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

}
