package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "resultado_mensal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoMensal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int mes;
    private int ano;
    private BigDecimal totalDeReceitas;
    private BigDecimal dizimo;
    private BigDecimal totalDeGastos;
    private BigDecimal totalAPagar;
    private BigDecimal saldoDoMes;
    private BigDecimal saldoAnterior;
    private BigDecimal receitaPoupada;
    private boolean isResultadoMensalFechado;
    private LocalDateTime createdAt;
}