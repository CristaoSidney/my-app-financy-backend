package br.com.cristaosidney.my_app_financy_backend.dto;

import br.com.cristaosidney.my_app_financy_backend.model.Natureza;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoContasDTO {
    private Long id;
    private String descricao;
    private Natureza naturezaDaConta;
    private LocalDateTime createdAt;
}
