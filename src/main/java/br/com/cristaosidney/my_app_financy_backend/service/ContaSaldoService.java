package br.com.cristaosidney.my_app_financy_backend.service;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.ContaSaldo;
import br.com.cristaosidney.my_app_financy_backend.repository.ContaSaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContaSaldoService {

    @Autowired
    private ContaSaldoRepository contaSaldoRepository;

    public List<ContaSaldo> findAll() {
        return contaSaldoRepository.findAll();
    }

    public Optional<ContaSaldo> findById(Long id) {
        return contaSaldoRepository.findById(id);
    }

    public ContaSaldo createContaSaldo(ContaSaldo contaSaldo) {
        return contaSaldoRepository.save(contaSaldo);
    }

    public ContaSaldo updateContaSaldo(Long id, ContaSaldo contaSaldoDetails) {
        return contaSaldoRepository.findById(id).map(contaSaldo -> {
            contaSaldo.setNome(contaSaldoDetails.getNome());
            contaSaldo.setDescricao(contaSaldoDetails.getDescricao());
            contaSaldo.setNaturezaDaConta(contaSaldoDetails.getNaturezaDaConta());
            contaSaldo.setDiaDeFechamentoMensal(contaSaldoDetails.getDiaDeFechamentoMensal());
            contaSaldo.setCreatedAt(contaSaldoDetails.getCreatedAt());
            return contaSaldoRepository.save(contaSaldo);
        }).orElseThrow(() -> new UpdateRecordException("Conta Saldo não encontrada"));
    }

    public void deleteById(Long id) {
        contaSaldoRepository.deleteById(id);
    }
}
