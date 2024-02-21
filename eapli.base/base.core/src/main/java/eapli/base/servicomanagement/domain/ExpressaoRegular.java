package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ExpressaoRegular implements ValueObject {

    private String expressaoRegular;


    public ExpressaoRegular(String expressaoRegular) {
        this.expressaoRegular = expressaoRegular;
    }

    public ExpressaoRegular() {

    }

    public String expressaoRegular() {
        if(expressaoRegular == null){
            return "";
        }
        return expressaoRegular;
    }
}
