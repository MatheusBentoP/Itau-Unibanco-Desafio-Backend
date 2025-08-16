package com.desafio.itau.dto;

import jakarta.validation.constraints.*;

import java.time.OffsetDateTime;


public class TransacaoRequest {

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    private Double valor;

    @PastOrPresent
    private OffsetDateTime dataHora;

    public TransacaoRequest(){

    }

    public TransacaoRequest(Double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }



}
