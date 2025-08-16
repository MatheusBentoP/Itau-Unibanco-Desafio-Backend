package com.desafio.itau.controller;

import com.desafio.itau.dto.EstatisticaResponse;
import com.desafio.itau.service.EstatisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatiscaController {

    private final EstatisticaService estatisticaService;

    public EstatiscaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }


    @GetMapping
    public ResponseEntity<EstatisticaResponse> gerarEstatistica(){
        EstatisticaResponse estatistica = estatisticaService.calcularEstatistica();
        return ResponseEntity.ok(estatistica);
    }






}
