package eapli.base.tarefamanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
public class Script implements ValueObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    private CodigoScript codigo;

    public Script(CodigoScript codigo) {
        this.codigo = codigo;
    }

    public Script() {

    }

    @Override
    public String toString() {
        return codigo.codigo();
    }
}
