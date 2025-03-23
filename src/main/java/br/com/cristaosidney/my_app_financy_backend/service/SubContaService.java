package br.com.cristaosidney.my_app_financy_backend.service;

import br.com.cristaosidney.my_app_financy_backend.dto.SubContaDTO;
import br.com.cristaosidney.my_app_financy_backend.exception.ResourceNotFoundException;
import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.GrupoContas;
import br.com.cristaosidney.my_app_financy_backend.model.SubConta;
import br.com.cristaosidney.my_app_financy_backend.repository.GrupoContasRepository;
import br.com.cristaosidney.my_app_financy_backend.repository.SubContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubContaService {

    @Autowired
    private SubContaRepository subContaRepository;

    @Autowired
    private GrupoContasRepository grupoContasRepository;

    public List<SubContaDTO> findAll() {
        List<SubConta> subContas = subContaRepository.findAll();
        if (subContas.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma SubConta encontrada");
        }
        return subContas.stream().map(SubContaDTO::new).collect(Collectors.toList());
    }

    public SubContaDTO findById(Long id) {
        return subContaRepository.findById(id)
                .map(SubContaDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("SubConta não encontrada"));
    }

    public SubContaDTO create(SubContaDTO dto) {
        try {
            GrupoContas grupo = grupoContasRepository.findById(dto.getGrupoContasId())
                    .orElseThrow(() -> new ResourceNotFoundException("Grupo de Contas não encontrado"));

            SubConta subConta = new SubConta(null, dto.getDescricao(), dto.getNaturezaDaConta(), LocalDateTime.now(), grupo);
            return new SubContaDTO(subContaRepository.save(subConta));

        } catch (Exception e) {
            throw new UpdateRecordException("Falha ao salvar SubConta");
        }
    }

    public SubContaDTO update(Long id, SubContaDTO dto) {
        if (!subContaRepository.existsById(id)) {
            throw new ResourceNotFoundException("SubConta não encontrada");
        }

        try {
            GrupoContas grupo = grupoContasRepository.findById(dto.getGrupoContasId())
                    .orElseThrow(() -> new ResourceNotFoundException("Grupo de Contas não encontrado"));

            SubConta subConta = new SubConta(id, dto.getDescricao(), dto.getNaturezaDaConta(), LocalDateTime.now(), grupo);
            return new SubContaDTO(subContaRepository.save(subConta));

        } catch (Exception e) {
            throw new UpdateRecordException("Falha ao atualizar SubConta");
        }
    }

    public void delete(Long id) {
        if (!subContaRepository.existsById(id)) {
            throw new ResourceNotFoundException("SubConta não encontrada");
        }

        try {
            subContaRepository.deleteById(id);
        } catch (Exception e) {
            throw new UpdateRecordException("Falha ao excluir SubConta");
        }
    }
}
