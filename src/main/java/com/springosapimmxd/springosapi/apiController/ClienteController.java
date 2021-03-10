package com.springosapimmxd.springosapi.apiController;

import com.springosapimmxd.springosapi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        Cliente cliente1 = new Cliente(1L,"fulano","fulano@lol.com","12345678");
        Cliente cliente2 = new Cliente(2L,"beltrano","beltrano@lol.com","98765432");
        return Arrays.asList(cliente1,cliente2);
    }

}
