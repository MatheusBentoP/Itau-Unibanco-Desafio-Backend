package com.desafio.itau.mapper;

import com.desafio.itau.dto.TransacaoRequest;
import com.desafio.itau.dto.TransacaoResponse;
import com.desafio.itau.model.Transacao;

public class TransacaoMapper {
    public static Transacao toEntity (TransacaoRequest transacaoRequest){
        Transacao transacao = new Transacao();
        transacao.setValor(transacaoRequest.getValor());
        transacao.setDataHora(transacaoRequest.getDataHora());

        return transacao;

    }

    public static TransacaoResponse toDto(Transacao transacao){
        return new TransacaoResponse(
                transacao.getValor(),
                transacao.getDataHora()
        );

    }
}
