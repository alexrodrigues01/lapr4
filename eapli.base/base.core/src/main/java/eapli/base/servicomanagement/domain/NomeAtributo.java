package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class NomeAtributo implements ValueObject {

    private String nomeAtributo;

    public NomeAtributo(String nomeAtributo) {
        this.nomeAtributo = nomeAtributo;
    }

    public NomeAtributo() {

    }

    public String nomeAtributo() {
        return nomeAtributo;
    }
}
