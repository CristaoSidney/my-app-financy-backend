package br.com.cristaosidney.my_app_financy_backend.service;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.DespesaMensalRecorrente;
import br.com.cristaosidney.my_app_financy_backend.repository.DespesaMensalRecorrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DespesaMensalRecorrenteService {

    @Autowired
    private DespesaMensalRecorrenteRepository despesaMensalRecorrenteRepository;

    public List<DespesaMensalRecorrente> findAll() {
        return despesaMensalRecorrenteRepository.findAll();
    }

    public Optional<DespesaMensalRecorrente> findById(Long id) {
        return despesaMensalRecorrenteRepository.findById(id);
    }

    public DespesaMensalRecorrente createDespesaMensalRecorrente(DespesaMensalRecorrente despesaMensalRecorrente) {
        return despesaMensalRecorrenteRepository.save(despesaMensalRecorrente);
    }

    public DespesaMensalRecorrente updateDespesaMensalRecorrente(Long id, DespesaMensalRecorrente despesaMensalRecorrenteDetails) {
        return despesaMensalRecorrenteRepository.findById(id).map(despesaMensalRecorrente -> {
            despesaMensalRecorrente.setDescricao(despesaMensalRecorrenteDetails.getDescricao());
            despesaMensalRecorrente.setValor(despesaMensalRecorrenteDetails.getValor());
            despesaMensalRecorrente.setDiaDoVencimento(despesaMensalRecorrenteDetails.getDiaDoVencimento());
            despesaMensalRecorrente.setCreatedAt(despesaMensalRecorrenteDetails.getCreatedAt());
            despesaMensalRecorrente.setContaSaldo(despesaMensalRecorrenteDetails.getContaSaldo());
            despesaMensalRecorrente.setGrupoContas(despesaMensalRecorrenteDetails.getGrupoContas());
            despesaMensalRecorrente.setSubConta(despesaMensalRecorrenteDetails.getSubConta());
            return despesaMensalRecorrenteRepository.save(despesaMensalRecorrente);
        }).orElseThrow(() -> new UpdateRecordException("Despesa Mensal Recorrente não encontrada"));
    }

    public void deleteById(Long id) {
        despesaMensalRecorrenteRepository.deleteById(id);
    }
}
