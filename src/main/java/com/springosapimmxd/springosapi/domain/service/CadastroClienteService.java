package com.springosapimmxd.springosapi.domain.service;

import com.springosapimmxd.springosapi.domain.exception.NegocioException;
import com.springosapimmxd.springosapi.domain.model.Cliente;
import com.springosapimmxd.springosapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());

        if(clienteExistente != null && !clienteExistente.equals(cliente)){
           throw new NegocioException("Já existe um cliente cadsatrado com esse e-mail");

        }
        return clienteRepository.save(cliente);
    }

    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }

}
