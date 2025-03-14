package br.com.cristaosidney.my_app_financy_backend.model;

import lombok.Getter;

@Getter
public enum Natureza {
    CREDITO("C"),
    DEBITO("D");
    private final String abreviado;

    Natureza(String abreviado) {
        this.abreviado = abreviado;
    }
}
