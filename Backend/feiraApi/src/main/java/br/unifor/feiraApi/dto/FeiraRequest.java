package br.unifor.feiraApi.dto;

import jakarta.validation.constraints.*;

public class FeiraRequest {
    @NotBlank(message = "O nome da feira é obrigatório")
    private String nome;

    @NotBlank(message = "A descrição da feira é obrigatória")
    private String descricao;

    @NotNull(message = "O ID do tipo de feira é obrigatório")
    private Long tipoFeiraId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getTipoFeiraId() {
        return tipoFeiraId;
    }

    public void setTipoFeiraId(Long tipoFeiraId) {
        this.tipoFeiraId = tipoFeiraId;
    }
}
