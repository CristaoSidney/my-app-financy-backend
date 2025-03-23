package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.dto.SubContaDTO;
import br.com.cristaosidney.my_app_financy_backend.exception.ResourceNotFoundException;
import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.service.SubContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sub-conta")
public class SubContaController {

    @Autowired
    private SubContaService subContaService;

    @GetMapping
    public ResponseEntity<List<SubContaDTO>> findAll() {
        try {
            return ResponseEntity.ok(subContaService.findAll());
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubContaDTO> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(subContaService.findById(id));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SubContaDTO> create(@RequestBody SubContaDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(subContaService.create(dto));
        } catch (UpdateRecordException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubContaDTO> update(@PathVariable Long id, @RequestBody SubContaDTO dto) {
        try {
            return ResponseEntity.ok(subContaService.update(id, dto));
        } catch (UpdateRecordException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            subContaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (UpdateRecordException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
