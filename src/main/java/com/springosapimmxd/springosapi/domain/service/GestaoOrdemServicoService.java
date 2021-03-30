package com.springosapimmxd.springosapi.domain.service;

import com.springosapimmxd.springosapi.domain.model.OrdemServico;
import com.springosapimmxd.springosapi.domain.model.StatusOrdemServico;
import com.springosapimmxd.springosapi.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;


    public OrdemServico criar(OrdemServico ordemServico){

        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());
        return ordemServicoRepository.save(ordemServico);

    }
}
