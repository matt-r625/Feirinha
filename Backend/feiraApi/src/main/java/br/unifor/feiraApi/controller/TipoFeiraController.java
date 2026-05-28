package br.unifor.feiraApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unifor.feiraApi.domain.TipoFeira;
import br.unifor.feiraApi.dto.TipoFeiraRequest;
import br.unifor.feiraApi.service.TipoFeiraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipo-feira")
public class TipoFeiraController {
    private final TipoFeiraService tipoFeiraService;

    public TipoFeiraController(TipoFeiraService tipoFeiraService) {
        this.tipoFeiraService = tipoFeiraService;
    }

    @GetMapping
    public List<TipoFeira> listarTiposFeira() {
        return tipoFeiraService.listarTiposFeira();
    }

    @PostMapping
    public ResponseEntity<TipoFeira> criarTipoFeira(@Valid @RequestBody TipoFeiraRequest request) {
        TipoFeira tipoFeira = tipoFeiraService.criarTipoFeira(request.getNome(), request.getDescricao());
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoFeira);
    }
}
