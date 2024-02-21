package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class UrgenciaPedido implements ValueObject {

    private String urgenciaPedido;

    public UrgenciaPedido(String urgenciaPedido) {
        this.urgenciaPedido = urgenciaPedido;
    }

    public UrgenciaPedido() {

    }

    public String urgenciaPedido() {
        return urgenciaPedido;
    }

    @Override
    public String toString() {
        return urgenciaPedido;
    }
}
