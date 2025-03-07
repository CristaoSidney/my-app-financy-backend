package br.com.cristaosidney.my_app_financy_backend.service;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.SubConta;
import br.com.cristaosidney.my_app_financy_backend.repository.SubContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubContaService {

    @Autowired
    private SubContaRepository subContaRepository;

    public List<SubConta> findAll() {
        return subContaRepository.findAll();
    }

    public Optional<SubConta> findById(Long id) {
        return subContaRepository.findById(id);
    }

    public SubConta createSubConta(SubConta subConta) {
        return subContaRepository.save(subConta);
    }

    public SubConta updateSubConta(Long id, SubConta subContaDetails) {
        return subContaRepository.findById(id).map(subConta -> {
            subConta.setDescricao(subContaDetails.getDescricao());
            subConta.setNaturezaDaConta(subContaDetails.getNaturezaDaConta());
            subConta.setCreatedAt(subContaDetails.getCreatedAt());
            subConta.setGrupoContas(subContaDetails.getGrupoContas());
            return subContaRepository.save(subConta);
        }).orElseThrow(() -> new UpdateRecordException("Sub Conta não encontrada"));
    }

    public void deleteById(Long id) {
        subContaRepository.deleteById(id);
    }
}
