package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.Lancamento;
import br.com.cristaosidney.my_app_financy_backend.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping
    public List<Lancamento> getAllLancamentos() {
        return lancamentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> getLancamentoById(@PathVariable Long id) {
        return lancamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lancamento createLancamento(@RequestBody Lancamento lancamento) {
        return lancamentoService.createLancamento(lancamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> updateLancamento(@PathVariable Long id, @RequestBody Lancamento lancamentoDetails) {
        try {
            Lancamento updatedLancamento = lancamentoService.updateLancamento(id, lancamentoDetails);
            return ResponseEntity.ok(updatedLancamento);
        } catch (UpdateRecordException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLancamento(@PathVariable Long id) {
        lancamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
