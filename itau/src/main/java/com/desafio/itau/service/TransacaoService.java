package com.desafio.itau.service;

import com.desafio.itau.dto.TransacaoRequest;
import com.desafio.itau.dto.TransacaoResponse;
import com.desafio.itau.mapper.TransacaoMapper;
import com.desafio.itau.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    public TransacaoResponse cadastraTransacao(TransacaoRequest transacaoRequest) {
        Transacao transacao = TransacaoMapper.toEntity(transacaoRequest);
        return TransacaoMapper.toDto(transacao);
    }

    private final List<Transacao> trasancoes = new ArrayList<>();

    public List<TransacaoResponse> mostraTransacao() {
        return trasancoes.stream().map(TransacaoMapper::toDto).collect(Collectors.toList());
    }
}