package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class DescricaoAtributo implements ValueObject {

    private  String descricao;

    public DescricaoAtributo(String descricao) {
        this.descricao = descricao;
    }

    public DescricaoAtributo() {

    }

    public String descricao() {
        return descricao;
    }
}
