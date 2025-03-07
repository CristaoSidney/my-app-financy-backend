package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ResultadoMensalContaSaldoId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "resultado_mensal_id")
    private ResultadoMensal resultadoMensal;

    @ManyToOne
    @JoinColumn(name = "conta_saldo_id")
    private ContaSaldo contaSaldo;
}
