package br.unifor.feiraApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.unifor.feiraApi.domain.Feira;
import br.unifor.feiraApi.domain.TipoFeira;
import br.unifor.feiraApi.dto.FeiraRequest;
import br.unifor.feiraApi.dto.FeiraResponse;
import br.unifor.feiraApi.repository.FeiraRepository;
import br.unifor.feiraApi.repository.TipoFeiraRepository;

@Service
public class FeiraService {
    private final FeiraRepository feiraRepository;
    private final TipoFeiraRepository tipoFeiraRepository;

    public FeiraService(FeiraRepository feiraRepository, TipoFeiraRepository tipoFeiraRepository) {
        this.feiraRepository = feiraRepository;
        this.tipoFeiraRepository = tipoFeiraRepository;
    }

    public List<FeiraResponse> listarFeiras() {
        return feiraRepository.findAll().stream()
                .map(feira -> new FeiraResponse(
                        feira.getId(),
                        feira.getNome(),
                        feira.getDescricao(),
                        feira.getTipoFeira().getNome()
                ))
                .collect(Collectors.toList());
    }

    public FeiraResponse criarFeira(FeiraRequest request) {
        TipoFeira tipoFeira = tipoFeiraRepository.findById(request.getTipoFeiraId())
                .orElseThrow(() -> new RuntimeException("Tipo de feira não encontrado"));

        Feira feira = new Feira(request.getNome(), request.getDescricao(), tipoFeira);
        Feira feiraSalva = feiraRepository.save(feira);
        return new FeiraResponse(feiraSalva.getId(), feiraSalva.getNome(),
                feiraSalva.getDescricao(), feiraSalva.getTipoFeira().getNome());
    }

    public void deletarFeira(Long id) {
        if (!feiraRepository.existsById(id)) {
            throw new RuntimeException("Feira não encontrada");
        }
        feiraRepository.deleteById(id);
    }
}
