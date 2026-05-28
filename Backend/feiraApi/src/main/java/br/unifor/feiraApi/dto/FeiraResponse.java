package br.unifor.feiraApi.dto;

public class FeiraResponse {
    private Long id;
    private String nome;
    private String descricao;
    private String tipoFeiraNome;

    public FeiraResponse(Long id, String nome, String descricao, String tipoFeiraNome) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipoFeiraNome = tipoFeiraNome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipoFeiraNome() {
        return tipoFeiraNome;
    }
}
