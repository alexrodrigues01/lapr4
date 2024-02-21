package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

@Entity
public class Keyword implements AggregateRoot<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = false, nullable = false)
    private String keyword;

    public Keyword(String keyword) {
        this.keyword = keyword;
    }

    public Keyword() {

    }

    public Long getId() {
        return id;
    }

    public String keyword() {
        return keyword;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void definirKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "Keyword: "+ keyword;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return id;
    }
}
