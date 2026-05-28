package br.unifor.feiraApi.dto;

import jakarta.validation.constraints.NotBlank;

public class TipoFeiraRequest {

    @NotBlank(message = "O nome do tipo de feira é obrigatório")
    private String nome;
    
    @NotBlank(message = "A descrição do tipo de feira é obrigatória")
    private String descricao;

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
}
