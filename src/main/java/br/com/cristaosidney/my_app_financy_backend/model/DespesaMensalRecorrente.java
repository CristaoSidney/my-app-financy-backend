package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "despesa_mensal_recorrente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DespesaMensalRecorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private BigDecimal valor;
    private int diaDoVencimento;
    private LocalDateTime createdAt;

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
