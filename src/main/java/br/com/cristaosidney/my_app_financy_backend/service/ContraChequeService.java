package br.com.cristaosidney.my_app_financy_backend.service;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.ContraCheque;
import br.com.cristaosidney.my_app_financy_backend.repository.ContraChequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContraChequeService {

    @Autowired
    private ContraChequeRepository contraChequeRepository;

    public List<ContraCheque> findAll() {
        return contraChequeRepository.findAll();
    }

    public Optional<ContraCheque> findById(Long id) {
        return contraChequeRepository.findById(id);
    }

    public ContraCheque createContraCheque(ContraCheque contraCheque) {
        return contraChequeRepository.save(contraCheque);
    }

    public ContraCheque updateContraCheque(Long id, ContraCheque contraChequeDetails) {
        return contraChequeRepository.findById(id).map(contraCheque -> {
            contraCheque.setMes(contraChequeDetails.getMes());
            contraCheque.setAno(contraChequeDetails.getAno());
            contraCheque.setFgts(contraChequeDetails.getFgts());
            contraCheque.setValorAuxilioAlimentacao(contraChequeDetails.getValorAuxilioAlimentacao());
            contraCheque.setOrcamento(contraChequeDetails.isOrcamento());
            contraCheque.setCreatedAt(contraChequeDetails.getCreatedAt());
            return contraChequeRepository.save(contraCheque);
        }).orElseThrow(() -> new UpdateRecordException("Contra Cheque não encontrado"));
    }

    public void deleteById(Long id) {
        contraChequeRepository.deleteById(id);
    }
}
