package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class PathFile implements ValueObject {

    private String pathFile;

    public PathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public PathFile() {

    }

    public String pathFile() {
        return pathFile;
    }
}
