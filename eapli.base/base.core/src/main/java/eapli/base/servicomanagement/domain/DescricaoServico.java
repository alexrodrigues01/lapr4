package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class DescricaoServico implements ValueObject {

    private String descricao;

    public DescricaoServico(String descricao) {
        this.descricao = descricao;
    }

    public DescricaoServico() {

    }

    public String descricao() {
        return descricao;
    }

    public void definirDescricao(String descricao) {
        this.descricao = descricao;
    }
}
