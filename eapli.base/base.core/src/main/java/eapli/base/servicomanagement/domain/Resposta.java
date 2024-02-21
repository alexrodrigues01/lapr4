package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import org.hibernate.annotations.Type;

import javax.persistence.Embeddable;

@Embeddable
public class Resposta implements ValueObject {

    private String resposta;

    public Resposta(String resposta) {
        this.resposta = resposta;
    }

    public Resposta() {

    }

    public String resposta() {
        if(resposta == null){
            return "";
        }
        return resposta;
    }
}
