package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Date;

@Embeddable
public class DataLimitePedido implements ValueObject {

    private LocalDate dataLimitePedido;

    public DataLimitePedido(LocalDate dataLimitePedido) {
        this.dataLimitePedido = dataLimitePedido;
    }

    public DataLimitePedido() {

    }

    public LocalDate dataLimitePedido() {
        return dataLimitePedido;
    }

    @Override
    public String toString() {
        return dataLimitePedido.toString();
    }
}
