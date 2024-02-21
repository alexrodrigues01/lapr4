package eapli.base.equipaManagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class TipoEquipa implements AggregateRoot<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique=false, nullable = false)
    private String codigoUnicoInterno;

    @Column(unique=false, nullable = false)
    private String descricao;

    @Column(unique=false, nullable = false)
    private String cor;

    public TipoEquipa(Integer id) {
        this.id = id;
    }

    public TipoEquipa(String codigoUnicoInterno, String descricao, String cor) {
        this.codigoUnicoInterno = codigoUnicoInterno;
        this.descricao = descricao;
        this.cor = cor;
    }

    public TipoEquipa() {

    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String codigoUnicoInterno() {
        return codigoUnicoInterno;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoEquipa)) return false;
        TipoEquipa that = (TipoEquipa) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TipoEquipa{" +
                "codigoUnicoInterno='" + codigoUnicoInterno + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }
}
