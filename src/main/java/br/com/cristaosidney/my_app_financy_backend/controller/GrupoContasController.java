package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.dto.GrupoContasDTO;
import br.com.cristaosidney.my_app_financy_backend.exception.ResourceNotFoundException;
import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.service.GrupoContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo-contas")
public class GrupoContasController {

    @Autowired
    private GrupoContasService grupoContasService;

    @GetMapping
    public ResponseEntity<List<GrupoContasDTO>> findAll() {
        List<GrupoContasDTO> grupos = grupoContasService.findAll();
        return grupos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(grupos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoContasDTO> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(grupoContasService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody GrupoContasDTO dto) {
        try {
            GrupoContasDTO created = grupoContasService.create(dto);
            return ResponseEntity.ok(created);
        } catch (UpdateRecordException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody GrupoContasDTO dto) {
        try {
            GrupoContasDTO updated = grupoContasService.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (UpdateRecordException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            grupoContasService.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content ao excluir com sucesso
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found se o ID não existir
        } catch (UpdateRecordException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); // 500 Internal Server Error se falhar ao excluir
        }
    }
}