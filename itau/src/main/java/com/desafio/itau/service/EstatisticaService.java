package com.desafio.itau.service;

import com.desafio.itau.dto.EstatisticaResponse;
import com.desafio.itau.dto.TransacaoRequest;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {
   private final TransacaoService transacaoService;

    public EstatisticaService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public EstatisticaResponse calcularEstatistica(){
        OffsetDateTime dataAgora = OffsetDateTime.now();

        List<Double> ultimosValores = transacaoService.getTransacoes().stream()
                .filter(t -> t.getDataHora().isAfter(dataAgora.minusSeconds(60)))
                .map(TransacaoRequest::getValor)
                .toList();

        if(ultimosValores.isEmpty()){
            return new EstatisticaResponse(0, 0.0, 0.0, 0.0, 0.0);

        }

        DoubleSummaryStatistics statistics = ultimosValores.stream().mapToDouble(Double::doubleValue).summaryStatistics();

        return new EstatisticaResponse(
                statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMin(),
                statistics.getMax()
        );

    }

}
