package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "conta_saldo")
@Data
public class ContaSaldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoContaSaldo tipoDaContaSaldo;

    @Enumerated(EnumType.STRING)
    private Natureza naturezaDaConta;

    private int diaDeFechamentoMensal;
    private LocalDateTime createdAt;
}
