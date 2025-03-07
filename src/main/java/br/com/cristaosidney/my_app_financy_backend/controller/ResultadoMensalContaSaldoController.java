package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.ResultadoMensalContaSaldo;
import br.com.cristaosidney.my_app_financy_backend.model.ResultadoMensalContaSaldoId;
import br.com.cristaosidney.my_app_financy_backend.service.ResultadoMensalContaSaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultado-mensal-conta-saldo")
public class ResultadoMensalContaSaldoController {

    @Autowired
    private ResultadoMensalContaSaldoService resultadoMensalContaSaldoService;

    @GetMapping
    public List<ResultadoMensalContaSaldo> getAllResultadoMensalContaSaldos() {
        return resultadoMensalContaSaldoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoMensalContaSaldo> getResultadoMensalContaSaldoById(@PathVariable ResultadoMensalContaSaldoId id) {
        return resultadoMensalContaSaldoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResultadoMensalContaSaldo createResultadoMensalContaSaldo(@RequestBody ResultadoMensalContaSaldo resultadoMensalContaSaldo) {
        return resultadoMensalContaSaldoService.createResultadoMensalContaSaldo(resultadoMensalContaSaldo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadoMensalContaSaldo> updateResultadoMensalContaSaldo(@PathVariable ResultadoMensalContaSaldoId id, @RequestBody ResultadoMensalContaSaldo resultadoMensalContaSaldoDetails) {
        try {
            ResultadoMensalContaSaldo updatedResultadoMensalContaSaldo = resultadoMensalContaSaldoService.updateResultadoMensalContaSaldo(id, resultadoMensalContaSaldoDetails);
            return ResponseEntity.ok(updatedResultadoMensalContaSaldo);
        } catch (UpdateRecordException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultadoMensalContaSaldo(@PathVariable ResultadoMensalContaSaldoId id) {
        resultadoMensalContaSaldoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}