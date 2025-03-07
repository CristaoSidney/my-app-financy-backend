package br.com.cristaosidney.my_app_financy_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "sub_conta")
@Data
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
