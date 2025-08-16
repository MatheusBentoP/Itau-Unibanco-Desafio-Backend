package com.desafio.itau.controller;


import com.desafio.itau.dto.EstatisticaResponse;
import com.desafio.itau.dto.TransacaoRequest;
import com.desafio.itau.dto.TransacaoResponse;
import com.desafio.itau.mapper.TransacaoMapper;
import com.desafio.itau.service.EstatisticaService;
import com.desafio.itau.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    private final EstatisticaService estatisticaService;


    public TransacaoController(TransacaoService transacaoService, EstatisticaService estatisticaService) {
        this.transacaoService = transacaoService;
        this.estatisticaService = estatisticaService;
    }


    @PostMapping
    public ResponseEntity<TransacaoResponse> cadastraTransacao(@Valid @RequestBody TransacaoRequest dto){
        transacaoService.salvarTransacao(dto);
        TransacaoResponse transacaoResponseNew = TransacaoMapper.toDto(TransacaoMapper.toEntity(dto));
        return ResponseEntity.status(201).body(transacaoResponseNew);

    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(){
        transacaoService.limparTransoes();
        return ResponseEntity.noContent().build();

    }


}
