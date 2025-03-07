package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.ContraCheque;
import br.com.cristaosidney.my_app_financy_backend.service.ContraChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contra-cheque")
public class ContraChequeController {

    @Autowired
    private ContraChequeService contraChequeService;

    @GetMapping
    public List<ContraCheque> getAllContraCheques() {
        return contraChequeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContraCheque> getContraChequeById(@PathVariable Long id) {
        return contraChequeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContraCheque createContraCheque(@RequestBody ContraCheque contraCheque) {
        return contraChequeService.createContraCheque(contraCheque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContraCheque> updateContraCheque(@PathVariable Long id, @RequestBody ContraCheque contraChequeDetails) {
        try {
            ContraCheque updatedContraCheque = contraChequeService.updateContraCheque(id, contraChequeDetails);
            return ResponseEntity.ok(updatedContraCheque);
        } catch (UpdateRecordException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContraCheque(@PathVariable Long id) {
        contraChequeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}