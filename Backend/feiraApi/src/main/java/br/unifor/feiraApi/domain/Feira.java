package br.unifor.feiraApi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "feira")
public class Feira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 200)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "tipo_feira_id", nullable = false)
    private TipoFeira tipoFeira;

    public Feira(String nome, String descricao, TipoFeira tipoFeira) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipoFeira = tipoFeira;
    }

    public Feira() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public TipoFeira getTipoFeira() {
        return tipoFeira;
    }

    public void setTipoFeira(TipoFeira tipoFeira) {
        this.tipoFeira = tipoFeira;
    }
}
