package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sub_conta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Natureza naturezaDaConta;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "grupo_contas_id")
    private GrupoContas grupoContas;
}
