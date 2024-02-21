package eapli.base.servicomanagement.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class EmailColaborador implements ValueObject {

    String emailColaborador;

    public EmailColaborador(String emailColaborador) {
        this.emailColaborador = emailColaborador;
    }

    public EmailColaborador() {

    }

    public String emailColaborador(){
        return this.emailColaborador;
    }

    @Override
    public String toString() {
        return emailColaborador;
    }
}
