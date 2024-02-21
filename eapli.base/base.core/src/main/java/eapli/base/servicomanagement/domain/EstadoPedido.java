package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class EstadoPedido implements ValueObject {

    public EstadoPedido() {

    }

    public enum EstadoPedidoEnum {
        SUBMETIDO,
        EM_APROVACAO,
        APROVADO,
        REJEITADO,
        EM_RESOLUCAO,
        CONCLUIDO,
        RESOLVIDO
    }

    public EstadoPedidoEnum estadoPedidoEnum() {
        return estadoPedidoEnum;
    }

    private EstadoPedidoEnum estadoPedidoEnum;

    public EstadoPedido(EstadoPedidoEnum estadoPedidoEnum) {
        this.estadoPedidoEnum = estadoPedidoEnum;
    }

    @Override
    public String toString() {
        return estadoPedidoEnum.toString();
    }
}
