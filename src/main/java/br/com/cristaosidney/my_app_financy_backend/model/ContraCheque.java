package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "contra_cheque")
@Data
public class ContraCheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int mes;
    private int ano;
    private BigDecimal fgts;
    private BigDecimal valorAuxilioAlimentacao;
    private boolean isOrcamento;
    private LocalDateTime createdAt;
}
