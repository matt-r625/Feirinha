package br.unifor.feiraApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.unifor.feiraApi.domain.TipoFeira;
import br.unifor.feiraApi.repository.TipoFeiraRepository;

@Service
public class TipoFeiraService {
    private final TipoFeiraRepository tipoFeiraRepository;

    public TipoFeiraService(TipoFeiraRepository tipoFeiraRepository) {
        this.tipoFeiraRepository = tipoFeiraRepository;
    }

    public List<TipoFeira> listarTiposFeira() {
        return tipoFeiraRepository.findAll();
    }

    public TipoFeira criarTipoFeira(String nome, String descricao) {
        TipoFeira tipoFeira = new TipoFeira(nome, descricao);
        return tipoFeiraRepository.save(tipoFeira);
    }
}
