package com.springosapimmxd.springosapi.repository;

import com.springosapimmxd.springosapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    Optional<Cliente> findByNome(String clienteNome);
}
