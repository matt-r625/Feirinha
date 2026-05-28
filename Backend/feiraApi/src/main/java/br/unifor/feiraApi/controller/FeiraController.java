package br.unifor.feiraApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unifor.feiraApi.dto.FeiraRequest;
import br.unifor.feiraApi.dto.FeiraResponse;
import br.unifor.feiraApi.service.FeiraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/feiras")
public class FeiraController {
    private final FeiraService feiraService;

    public FeiraController(FeiraService feiraService) {
        this.feiraService = feiraService;
    }

    @GetMapping
    public ResponseEntity<List<FeiraResponse>> listarFeiras() {
        return ResponseEntity.ok(feiraService.listarFeiras());
    }

    @PostMapping
    public ResponseEntity<FeiraResponse> criarFeira(@Valid @RequestBody FeiraRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feiraService.criarFeira(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFeira(@PathVariable Long id) {
        feiraService.deletarFeira(id);
        return ResponseEntity.noContent().build();
    }
}
