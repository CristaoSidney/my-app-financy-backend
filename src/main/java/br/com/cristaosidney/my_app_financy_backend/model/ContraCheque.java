package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "contra_cheque")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
