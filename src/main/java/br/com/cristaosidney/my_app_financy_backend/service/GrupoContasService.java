package br.com.cristaosidney.my_app_financy_backend.service;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.GrupoContas;
import br.com.cristaosidney.my_app_financy_backend.repository.GrupoContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GrupoContasService {

    @Autowired
    private GrupoContasRepository grupoContasRepository;

    public List<GrupoContas> findAll() {
        return grupoContasRepository.findAll();
    }

    public Optional<GrupoContas> findById(Long id) {
        return grupoContasRepository.findById(id);
    }

    public GrupoContas createGrupoContas(GrupoContas grupoContas) {
        return grupoContasRepository.save(grupoContas);
    }

    public GrupoContas updateGrupoContas(Long id, GrupoContas grupoContasDetails) {
        return grupoContasRepository.findById(id).map(grupoContas -> {
            grupoContas.setDescricao(grupoContasDetails.getDescricao());
            grupoContas.setNaturezaDaConta(grupoContasDetails.getNaturezaDaConta());
            grupoContas.setCreatedAt(grupoContasDetails.getCreatedAt());
            return grupoContasRepository.save(grupoContas);
        }).orElseThrow(() -> new UpdateRecordException("Grupo de Contas não encontrado"));
    }

    public void deleteById(Long id) {
        grupoContasRepository.deleteById(id);
    }
}