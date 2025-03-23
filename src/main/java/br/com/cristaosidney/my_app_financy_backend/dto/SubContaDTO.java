package br.com.cristaosidney.my_app_financy_backend.dto;

import br.com.cristaosidney.my_app_financy_backend.model.Natureza;
import br.com.cristaosidney.my_app_financy_backend.model.SubConta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubContaDTO {
    private Long id;
    private String descricao;
    private Natureza naturezaDaConta;
    private LocalDateTime createdAt;
    private Long grupoContasId;
    private String grupoContasDescricao;

    public SubContaDTO(SubConta subConta) {
        this.id = subConta.getId();
        this.descricao = subConta.getDescricao();
        this.naturezaDaConta = subConta.getNaturezaDaConta();
        this.createdAt = subConta.getCreatedAt();
        this.grupoContasId = subConta.getGrupoContas().getId();
        this.grupoContasDescricao = subConta.getGrupoContas().getDescricao();
    }
}
