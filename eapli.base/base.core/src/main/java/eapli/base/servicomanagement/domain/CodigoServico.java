package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class CodigoServico implements ValueObject {

    private String codigo;

    public CodigoServico(String codigo) {
        this.codigo = codigo;
    }

    public CodigoServico() {

    }

    public String codigo() {
        return codigo;
    }

    public void definirCodigo(String codigo) {
        this.codigo = codigo;
    }
}
