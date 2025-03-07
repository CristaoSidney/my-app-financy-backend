package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.ContaSaldo;
import br.com.cristaosidney.my_app_financy_backend.service.ContaSaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conta-saldo")
public class ContaSaldoController {

    @Autowired
    private ContaSaldoService contaSaldoService;

    @GetMapping
    public List<ContaSaldo> getAllContaSaldos() {
        return contaSaldoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaSaldo> getContaSaldoById(@PathVariable Long id) {
        return contaSaldoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContaSaldo createContaSaldo(@RequestBody ContaSaldo contaSaldo) {
        return contaSaldoService.createContaSaldo(contaSaldo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaSaldo> updateContaSaldo(@PathVariable Long id, @RequestBody ContaSaldo contaSaldoDetails) {
        try {
            ContaSaldo updatedContaSaldo = contaSaldoService.updateContaSaldo(id, contaSaldoDetails);
            return ResponseEntity.ok(updatedContaSaldo);
        } catch (UpdateRecordException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContaSaldo(@PathVariable Long id) {
        contaSaldoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
