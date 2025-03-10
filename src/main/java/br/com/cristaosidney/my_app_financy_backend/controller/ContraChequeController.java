package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.exception.ResourceNotFoundException;
import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.ContraCheque;
import br.com.cristaosidney.my_app_financy_backend.model.ContraChequeRubrica;
import br.com.cristaosidney.my_app_financy_backend.service.ContraChequeRubricaService;
import br.com.cristaosidney.my_app_financy_backend.service.ContraChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contra-cheque")
public class ContraChequeController {

    @Autowired
    private ContraChequeService contraChequeService;

    @Autowired
    private ContraChequeRubricaService contraChequeRubricaService;

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

    @GetMapping("/{contraChequeId}/rubricas")
    public List<ContraChequeRubrica> getAllRubricasByContraChequeId(@PathVariable Long contraChequeId) {
        return contraChequeRubricaService.findAllByContraChequeId(contraChequeId);
    }

    @GetMapping("/{contraChequeId}/rubricas/{id}")
    public ResponseEntity<ContraChequeRubrica> getRubricaById(@PathVariable Long contraChequeId, @PathVariable Long id) {
        return contraChequeRubricaService.findByIdAndContraChequeId(id, contraChequeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{contraChequeId}/rubricas")
    public ContraChequeRubrica createRubrica(@PathVariable Long contraChequeId, @RequestBody ContraChequeRubrica rubrica) {
        ContraCheque contraCheque = contraChequeService.findById(contraChequeId)
                .orElseThrow(() -> new ResourceNotFoundException("ContraCheque not found with id " + contraChequeId));
        rubrica.setContraCheque(contraCheque);
        return contraChequeRubricaService.createContraChequeRubrica(rubrica);
    }

    @PutMapping("/{contraChequeId}/rubricas/{id}")
    public ResponseEntity<ContraChequeRubrica> updateRubrica(@PathVariable Long contraChequeId, @PathVariable Long id, @RequestBody ContraChequeRubrica rubricaDetails) {
        try {
            ContraCheque contraCheque = contraChequeService.findById(contraChequeId)
                    .orElseThrow(() -> new ResourceNotFoundException("ContraCheque not found with id " + contraChequeId));
            rubricaDetails.setContraCheque(contraCheque);
            ContraChequeRubrica updatedRubrica = contraChequeRubricaService.updateContraChequeRubrica(id, rubricaDetails);
            return ResponseEntity.ok(updatedRubrica);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (UpdateRecordException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{contraChequeId}/rubricas/{id}")
    public ResponseEntity<Void> deleteRubrica(@PathVariable Long contraChequeId, @PathVariable Long id) {
        contraChequeRubricaService.deleteByIdAndContraChequeId(id, contraChequeId);
        return ResponseEntity.noContent().build();
    }
}