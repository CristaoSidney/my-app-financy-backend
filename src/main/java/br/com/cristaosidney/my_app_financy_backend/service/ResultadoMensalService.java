package br.com.cristaosidney.my_app_financy_backend.service;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.ResultadoMensal;
import br.com.cristaosidney.my_app_financy_backend.repository.ResultadoMensalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResultadoMensalService {

    @Autowired
    private ResultadoMensalRepository resultadoMensalRepository;

    public List<ResultadoMensal> findAll() {
        return resultadoMensalRepository.findAll();
    }

    public Optional<ResultadoMensal> findById(Long id) {
        return resultadoMensalRepository.findById(id);
    }

    public ResultadoMensal createResultadoMensal(ResultadoMensal resultadoMensal) {
        return resultadoMensalRepository.save(resultadoMensal);
    }

    public ResultadoMensal updateResultadoMensal(Long id, ResultadoMensal resultadoMensalDetails) {
        return resultadoMensalRepository.findById(id).map(resultadoMensal -> {
            resultadoMensal.setMes(resultadoMensalDetails.getMes());
            resultadoMensal.setAno(resultadoMensalDetails.getAno());
            resultadoMensal.setTotalDeReceitas(resultadoMensalDetails.getTotalDeReceitas());
            resultadoMensal.setDizimo(resultadoMensalDetails.getDizimo());
            resultadoMensal.setTotalDeGastos(resultadoMensalDetails.getTotalDeGastos());
            resultadoMensal.setTotalAPagar(resultadoMensalDetails.getTotalAPagar());
            resultadoMensal.setSaldoDoMes(resultadoMensalDetails.getSaldoDoMes());
            resultadoMensal.setSaldoAnterior(resultadoMensalDetails.getSaldoAnterior());
            resultadoMensal.setReceitaPoupada(resultadoMensalDetails.getReceitaPoupada());
            resultadoMensal.setResultadoMensalFechado(resultadoMensalDetails.isResultadoMensalFechado());
            resultadoMensal.setCreatedAt(resultadoMensalDetails.getCreatedAt());
            return resultadoMensalRepository.save(resultadoMensal);
        }).orElseThrow(() -> new UpdateRecordException("Resultado Mensal não encontrado"));
    }

    public void deleteById(Long id) {
        resultadoMensalRepository.deleteById(id);
    }
}
