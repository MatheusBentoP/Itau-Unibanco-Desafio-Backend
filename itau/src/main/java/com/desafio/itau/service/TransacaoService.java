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

    private final List<TransacaoRequest> transacoes = new ArrayList<>();

    public void salvarTransacao(TransacaoRequest dto) {
        transacoes.add(dto);
    }

    public void limparTransoes(){
        transacoes.clear();
    }



    public List<TransacaoRequest> getTransacoes() {
        return transacoes;
    }

}
