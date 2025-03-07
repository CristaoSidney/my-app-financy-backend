package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.SubConta;
import br.com.cristaosidney.my_app_financy_backend.service.SubContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sub-conta")
public class SubContaController {

    @Autowired
    private SubContaService subContaService;

    @GetMapping
    public List<SubConta> getAllSubContas() {
        return subContaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubConta> getSubContaById(@PathVariable Long id) {
        return subContaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SubConta createSubConta(@RequestBody SubConta subConta) {
        return subContaService.createSubConta(subConta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubConta> updateSubConta(@PathVariable Long id, @RequestBody SubConta subContaDetails) {
        try {
            SubConta updatedSubConta = subContaService.updateSubConta(id, subContaDetails);
            return ResponseEntity.ok(updatedSubConta);
        } catch (UpdateRecordException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubConta(@PathVariable Long id) {
        subContaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
