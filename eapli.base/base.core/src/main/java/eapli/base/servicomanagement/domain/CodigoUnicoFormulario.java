package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class CodigoUnicoFormulario implements ValueObject {
    private String codigoUnico;

    public CodigoUnicoFormulario(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public CodigoUnicoFormulario() {

    }

    public String codigoUnico() {
        return codigoUnico;
    }

    public void definirCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
}
