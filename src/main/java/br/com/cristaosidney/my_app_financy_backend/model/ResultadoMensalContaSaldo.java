package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "resultado_mensal_conta_saldo")
@Data
public class ResultadoMensalContaSaldo {

    @EmbeddedId
    private ResultadoMensalContaSaldoId id;

    private LocalDateTime createdAt;
}

