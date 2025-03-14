package br.com.cristaosidney.my_app_financy_backend.model;

import lombok.Getter;

@Getter
public enum TipoContaSaldo {
    CONTA_CORRENTE("C/C", "Conta corrente"),
    CAIXA("CX", "Caixa"),
    APLICATIVO("APP", "Aplicativo"),
    INVESTIMENTO("INV", "Investimento"),
    CARTAO("CT", "Cartão");

    private final String abreviado;
    private final String nomeCompleto;

    TipoContaSaldo(String abreviado, String nomeCompleto) {
        this.abreviado = abreviado;
        this.nomeCompleto = nomeCompleto;
    }
}
