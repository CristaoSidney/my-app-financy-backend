package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "lancamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observacao;

    @Enumerated(EnumType.STRING)
    private Natureza naturezaDoLancamento;

    private BigDecimal valor;
    private int parcelaAtual;
    private int parcelamentoTotal;
    private LocalDate dataDeLancamento;
    private LocalDate dataDeVencimento;
    private LocalDate dataDePagamento;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "resultado_mensal_id")
    private ResultadoMensal resultadoMensal;

    @ManyToOne
    @JoinColumn(name = "conta_saldo_id")
    private ContaSaldo contaSaldo;

    @ManyToOne
    @JoinColumn(name = "grupo_contas_id")
    private GrupoContas grupoContas;

    @ManyToOne
    @JoinColumn(name = "sub_conta_id")
    private SubConta subConta;
}
