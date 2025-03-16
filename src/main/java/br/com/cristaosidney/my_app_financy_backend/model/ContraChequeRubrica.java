package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "contra_cheque_rubrica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContraChequeRubrica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Natureza naturezaDaRubrica;

    private BigDecimal valor;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "contra_cheque_id")
    private ContraCheque contraCheque;
}
