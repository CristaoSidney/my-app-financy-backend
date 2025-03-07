package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.GrupoContas;
import br.com.cristaosidney.my_app_financy_backend.service.GrupoContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo-contas")
public class GrupoContasController {

    @Autowired
    private GrupoContasService grupoContasService;

    @GetMapping
    public List<GrupoContas> getAllGrupoContas() {
        return grupoContasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoContas> getGrupoContasById(@PathVariable Long id) {
        return grupoContasService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GrupoContas createGrupoContas(@RequestBody GrupoContas grupoContas) {
        return grupoContasService.createGrupoContas(grupoContas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoContas> updateGrupoContas(@PathVariable Long id, @RequestBody GrupoContas grupoContasDetails) {
        try {
            GrupoContas updatedGrupoContas = grupoContasService.updateGrupoContas(id, grupoContasDetails);
            return ResponseEntity.ok(updatedGrupoContas);
        } catch (UpdateRecordException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupoContas(@PathVariable Long id) {
        grupoContasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}