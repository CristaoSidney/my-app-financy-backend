package br.com.cristaosidney.my_app_financy_backend.service;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.Lancamento;
import br.com.cristaosidney.my_app_financy_backend.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
    }

    public Optional<Lancamento> findById(Long id) {
        return lancamentoRepository.findById(id);
    }

    public Lancamento createLancamento(Lancamento lancamento) {
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento updateLancamento(Long id, Lancamento lancamentoDetails) {
        return lancamentoRepository.findById(id).map(lancamento -> {
            lancamento.setObservacao(lancamentoDetails.getObservacao());
            lancamento.setNaturezaDoLancamento(lancamentoDetails.getNaturezaDoLancamento());
            lancamento.setValor(lancamentoDetails.getValor());
            lancamento.setParcelaAtual(lancamentoDetails.getParcelaAtual());
            lancamento.setParcelamentoTotal(lancamentoDetails.getParcelamentoTotal());
            lancamento.setDataDeLancamento(lancamentoDetails.getDataDeLancamento());
            lancamento.setDataDeVencimento(lancamentoDetails.getDataDeVencimento());
            lancamento.setDataDePagamento(lancamentoDetails.getDataDePagamento());
            lancamento.setCreatedAt(lancamentoDetails.getCreatedAt());
            lancamento.setResultadoMensal(lancamentoDetails.getResultadoMensal());
            lancamento.setContaSaldo(lancamentoDetails.getContaSaldo());
            lancamento.setGrupoContas(lancamentoDetails.getGrupoContas());
            lancamento.setSubConta(lancamentoDetails.getSubConta());
            return lancamentoRepository.save(lancamento);
        }).orElseThrow(() -> new UpdateRecordException("Lançamento não encontrado"));
    }

    public void deleteById(Long id) {
        lancamentoRepository.deleteById(id);
    }
}
