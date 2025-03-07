package br.com.cristaosidney.my_app_financy_backend.service;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.ResultadoMensalContaSaldo;
import br.com.cristaosidney.my_app_financy_backend.model.ResultadoMensalContaSaldoId;
import br.com.cristaosidney.my_app_financy_backend.repository.ResultadoMensalContaSaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResultadoMensalContaSaldoService {

    @Autowired
    private ResultadoMensalContaSaldoRepository resultadoMensalContaSaldoRepository;

    public List<ResultadoMensalContaSaldo> findAll() {
        return resultadoMensalContaSaldoRepository.findAll();
    }

    public Optional<ResultadoMensalContaSaldo> findById(ResultadoMensalContaSaldoId id) {
        return resultadoMensalContaSaldoRepository.findById(id);
    }

    public ResultadoMensalContaSaldo createResultadoMensalContaSaldo(ResultadoMensalContaSaldo resultadoMensalContaSaldo) {
        return resultadoMensalContaSaldoRepository.save(resultadoMensalContaSaldo);
    }

    public ResultadoMensalContaSaldo updateResultadoMensalContaSaldo(ResultadoMensalContaSaldoId id, ResultadoMensalContaSaldo resultadoMensalContaSaldoDetails) {
        return resultadoMensalContaSaldoRepository.findById(id).map(resultadoMensalContaSaldo -> {
            resultadoMensalContaSaldo.setId(resultadoMensalContaSaldoDetails.getId());
            resultadoMensalContaSaldo.setCreatedAt(resultadoMensalContaSaldoDetails.getCreatedAt());
            return resultadoMensalContaSaldoRepository.save(resultadoMensalContaSaldo);
        }).orElseThrow(() -> new UpdateRecordException("Resultado Mensal Conta Saldo não encontrado"));
    }

    public void deleteById(ResultadoMensalContaSaldoId id) {
        resultadoMensalContaSaldoRepository.deleteById(id);
    }
}
