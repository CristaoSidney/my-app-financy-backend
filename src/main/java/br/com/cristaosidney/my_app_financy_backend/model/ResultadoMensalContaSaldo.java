package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "resultado_mensal_conta_saldo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoMensalContaSaldo {

    @EmbeddedId
    private ResultadoMensalContaSaldoId id;

    private LocalDateTime createdAt;
}

