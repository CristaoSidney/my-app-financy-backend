package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.ContraChequeRubrica;
import br.com.cristaosidney.my_app_financy_backend.service.ContraChequeRubricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contra-cheque-rubrica")
public class ContraChequeRubricaController {

    @Autowired
    private ContraChequeRubricaService contraChequeRubricaService;

    @GetMapping
    public List<ContraChequeRubrica> getAllContraChequeRubricas() {
        return contraChequeRubricaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContraChequeRubrica> getContraChequeRubricaById(@PathVariable Long id) {
        return contraChequeRubricaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContraChequeRubrica createContraChequeRubrica(@RequestBody ContraChequeRubrica contraChequeRubrica) {
        return contraChequeRubricaService.createContraChequeRubrica(contraChequeRubrica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContraChequeRubrica> updateContraChequeRubrica(@PathVariable Long id, @RequestBody ContraChequeRubrica contraChequeRubricaDetails) {
        try {
            ContraChequeRubrica updatedContraChequeRubrica = contraChequeRubricaService.updateContraChequeRubrica(id, contraChequeRubricaDetails);
            return ResponseEntity.ok(updatedContraChequeRubrica);
        } catch (UpdateRecordException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContraChequeRubrica(@PathVariable Long id) {
        contraChequeRubricaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
