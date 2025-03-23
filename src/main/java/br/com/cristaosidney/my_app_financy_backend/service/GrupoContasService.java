package br.com.cristaosidney.my_app_financy_backend.service;

import br.com.cristaosidney.my_app_financy_backend.dto.GrupoContasDTO;
import br.com.cristaosidney.my_app_financy_backend.exception.ResourceNotFoundException;
import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.GrupoContas;
import br.com.cristaosidney.my_app_financy_backend.repository.GrupoContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoContasService {

    @Autowired
    private GrupoContasRepository grupoContasRepository;

    public List<GrupoContasDTO> findAll() {
        List<GrupoContas> grupos = grupoContasRepository.findAll();
        if (grupos.isEmpty()) {
            return Collections.emptyList(); // O Controller lidará com isso retornando 404
        }
        return grupos.stream()
                .map(g -> new GrupoContasDTO(g.getId(), g.getDescricao(), g.getNaturezaDaConta(), g.getCreatedAt()))
                .collect(Collectors.toList());
    }

    public GrupoContasDTO findById(Long id) {
        GrupoContas grupoContas = grupoContasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo de Contas não encontrado"));
        return new GrupoContasDTO(grupoContas.getId(), grupoContas.getDescricao(), grupoContas.getNaturezaDaConta(), grupoContas.getCreatedAt());
    }

    public GrupoContasDTO create(GrupoContasDTO dto) {
        try {
            GrupoContas grupoContas = new GrupoContas(null, dto.getDescricao(), dto.getNaturezaDaConta(), LocalDateTime.now());
            grupoContas = grupoContasRepository.save(grupoContas);
            return new GrupoContasDTO(grupoContas.getId(), grupoContas.getDescricao(), grupoContas.getNaturezaDaConta(), grupoContas.getCreatedAt());
        } catch (Exception e) {
            throw new UpdateRecordException("Falha ao criar Grupo de Contas");
        }
    }

    public GrupoContasDTO update(Long id, GrupoContasDTO dto) {
        GrupoContas grupoContas = grupoContasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo de Contas não encontrado"));

        try {
            grupoContas.setDescricao(dto.getDescricao());
            grupoContas.setNaturezaDaConta(dto.getNaturezaDaConta());

            grupoContas = grupoContasRepository.save(grupoContas);
            return new GrupoContasDTO(grupoContas.getId(), grupoContas.getDescricao(), grupoContas.getNaturezaDaConta(), grupoContas.getCreatedAt());
        } catch (Exception e) {
            throw new UpdateRecordException("Falha ao atualizar Grupo de Contas");
        }
    }

    public void deleteById(Long id) {
        if (!grupoContasRepository.existsById(id)) {
            throw new ResourceNotFoundException("Grupo de Contas não encontrado");
        }
        try {
            grupoContasRepository.deleteById(id);
        } catch (Exception e) {
            throw new UpdateRecordException("Falha ao excluir Grupo de Contas");
        }
    }
}