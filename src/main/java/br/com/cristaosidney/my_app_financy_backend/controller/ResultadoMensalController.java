package br.com.cristaosidney.my_app_financy_backend.controller;

import br.com.cristaosidney.my_app_financy_backend.exception.UpdateRecordException;
import br.com.cristaosidney.my_app_financy_backend.model.ResultadoMensal;
import br.com.cristaosidney.my_app_financy_backend.service.ResultadoMensalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultado-mensal")
public class ResultadoMensalController {

    @Autowired
    private ResultadoMensalService resultadoMensalService;

    @GetMapping
    public List<ResultadoMensal> getAllResultadoMensals() {
        return resultadoMensalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoMensal> getResultadoMensalById(@PathVariable Long id) {
        return resultadoMensalService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResultadoMensal createResultadoMensal(@RequestBody ResultadoMensal resultadoMensal) {
        return resultadoMensalService.createResultadoMensal(resultadoMensal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadoMensal> updateResultadoMensal(@PathVariable Long id, @RequestBody ResultadoMensal resultadoMensalDetails) {
        try {
            ResultadoMensal updatedResultadoMensal = resultadoMensalService.updateResultadoMensal(id, resultadoMensalDetails);
            return ResponseEntity.ok(updatedResultadoMensal);
        } catch (UpdateRecordException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultadoMensal(@PathVariable Long id) {
        resultadoMensalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
