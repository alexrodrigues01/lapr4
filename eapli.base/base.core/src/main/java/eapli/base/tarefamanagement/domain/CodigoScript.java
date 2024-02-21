package eapli.base.tarefamanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class CodigoScript implements ValueObject {

    @Lob
    private String codigo;

    public CodigoScript(String nome) {
        this.codigo = nome;
    }

    public CodigoScript() {

    }

    public String codigo() {
        return codigo;
    }

}
