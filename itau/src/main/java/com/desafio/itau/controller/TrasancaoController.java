package com.desafio.itau.controller;


import com.desafio.itau.dto.TransacaoRequest;
import com.desafio.itau.dto.TransacaoResponse;
import com.desafio.itau.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityReturnValueHandler;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TrasancaoController {

    private final TransacaoService transacaoService;

    public TrasancaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }


    @PostMapping
    public ResponseEntity<TransacaoResponse> cadastraTransacao(@Valid @RequestBody TransacaoRequest dto){
        TransacaoResponse transacaoResponseNew = transacaoService.cadastraTransacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoResponseNew);

    }


    @DeleteMapping
    public ResponseEntity<Void> deletar(){
        transacaoService.limparTransoes();
        return ResponseEntity.noContent().build();

    }


}
