package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.DespesaMensalRecorrente;
import br.com.cristaosidney.my_app_financy_backend.service.DespesaMensalRecorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/despesa-mensal-recorrente")
public class DespesaMensalRecorrenteController {

    @Autowired
    private DespesaMensalRecorrenteService despesaMensalRecorrenteService;

    @GetMapping
    public List<DespesaMensalRecorrente> getAllDespesasMensaisRecorrentes() {
        return despesaMensalRecorrenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaMensalRecorrente> getDespesaMensalRecorrenteById(@PathVariable Long id) {
        return despesaMensalRecorrenteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DespesaMensalRecorrente createDespesaMensalRecorrente(@RequestBody DespesaMensalRecorrente despesaMensalRecorrente) {
        return despesaMensalRecorrenteService.createDespesaMensalRecorrente(despesaMensalRecorrente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespesaMensalRecorrente> updateDespesaMensalRecorrente(@PathVariable Long id, @RequestBody DespesaMensalRecorrente despesaMensalRecorrenteDetails) {
        try {
            DespesaMensalRecorrente updatedDespesaMensalRecorrente = despesaMensalRecorrenteService.updateDespesaMensalRecorrente(id, despesaMensalRecorrenteDetails);
            return ResponseEntity.ok(updatedDespesaMensalRecorrente);
        } catch (UpdateRecordException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDespesaMensalRecorrente(@PathVariable Long id) {
        despesaMensalRecorrenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
