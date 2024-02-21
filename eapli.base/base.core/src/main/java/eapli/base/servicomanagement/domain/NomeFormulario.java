package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class NomeFormulario implements ValueObject {

    private String nome;


    public NomeFormulario(String nome) {
        this.nome = nome;
    }

    public NomeFormulario() {

    }

    public String nome() {
        return nome;
    }
}
