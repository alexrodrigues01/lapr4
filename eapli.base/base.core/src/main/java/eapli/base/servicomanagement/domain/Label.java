package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Label implements ValueObject {

    private String label;

    public Label(String label) {
        this.label = label;
    }

    public Label() {

    }

    public String label() {
        return label;
    }
}
