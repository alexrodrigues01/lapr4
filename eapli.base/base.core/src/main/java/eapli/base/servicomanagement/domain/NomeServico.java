package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NomeServico implements ValueObject {
    @Column(name="nome_servico")
    private String nome;

    public NomeServico(String nome) {
        this.nome = nome;
    }

    public NomeServico() {

    }

    public String nome() {
        return nome;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }
}
