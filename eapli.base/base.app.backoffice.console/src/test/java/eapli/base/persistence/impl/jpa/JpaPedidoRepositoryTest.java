package eapli.base.persistence.impl.jpa;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.repositories.PedidoRepository;
import junit.framework.TestCase;

import java.nio.charset.StandardCharsets;

public class JpaPedidoRepositoryTest extends TestCase {

    public void testGetPedidosUser() {
        PedidoRepository pedidoRepository= PersistenceContext.repositories().pedido();
        System.out.println(pedidoRepository.getPedidosUser("email1@email.pt"));
    }

    public void testGetPedidosById() {
        PedidoRepository pedidoRepository= PersistenceContext.repositories().pedido();
        System.out.println(pedidoRepository.getPedidosById("2021/1").emailColaborador());
        System.out.println(new String("2021/1").getBytes(StandardCharsets.UTF_8).length);
    }


}