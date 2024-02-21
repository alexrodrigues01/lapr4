package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class TipoDados implements ValueObject {

    private String tipoDados;

    public TipoDados(String tipoDados) {
        this.tipoDados = tipoDados;
    }

    public TipoDados() {

    }

    public String tipoDados() {
        return tipoDados;
    }
}
