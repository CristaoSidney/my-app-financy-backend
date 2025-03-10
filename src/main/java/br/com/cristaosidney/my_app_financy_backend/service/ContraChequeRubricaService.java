package br.com.cristaosidney.my_app_financy_backend.service;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.ContraChequeRubrica;
import br.com.cristaosidney.my_app_financy_backend.repository.ContraChequeRubricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContraChequeRubricaService {

    @Autowired
    private ContraChequeRubricaRepository contraChequeRubricaRepository;

    public List<ContraChequeRubrica> findAll() {
        return contraChequeRubricaRepository.findAll();
    }

    public Optional<ContraChequeRubrica> findById(Long id) {
        return contraChequeRubricaRepository.findById(id);
    }

    public ContraChequeRubrica createContraChequeRubrica(ContraChequeRubrica contraChequeRubrica) {
        return contraChequeRubricaRepository.save(contraChequeRubrica);
    }

    public ContraChequeRubrica updateContraChequeRubrica(Long id, ContraChequeRubrica contraChequeRubricaDetails) {
        return contraChequeRubricaRepository.findById(id).map(contraChequeRubrica -> {
            contraChequeRubrica.setDescricao(contraChequeRubricaDetails.getDescricao());
            contraChequeRubrica.setNaturezaDaRubrica(contraChequeRubricaDetails.getNaturezaDaRubrica());
            contraChequeRubrica.setValor(contraChequeRubricaDetails.getValor());
            contraChequeRubrica.setCreatedAt(contraChequeRubricaDetails.getCreatedAt());
            contraChequeRubrica.setContraCheque(contraChequeRubricaDetails.getContraCheque());
            return contraChequeRubricaRepository.save(contraChequeRubrica);
        }).orElseThrow(() -> new UpdateRecordException("Contra Cheque Rubrica não encontrada"));
    }

    public void deleteById(Long id) {
        contraChequeRubricaRepository.deleteById(id);
    }

    public void deleteByIdAndContraChequeId(Long id, Long contraChequeId) {
        contraChequeRubricaRepository.deleteByIdAndContraChequeId(id, contraChequeId);
    }

    public Optional<ContraChequeRubrica> findByIdAndContraChequeId(Long id, Long contraChequeId) {
        return contraChequeRubricaRepository.findByIdAndContraChequeId(id, contraChequeId);
    }

    public List<ContraChequeRubrica> findAllByContraChequeId(Long contraChequeId) {
        return contraChequeRubricaRepository.findAllByContraChequeId(contraChequeId);
    }
}
