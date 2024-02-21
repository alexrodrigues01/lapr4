package eapli.base.servicomanagement.domain;

import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;

public class PedidoDTO {

    private NivelCriticidade nivelCriticidade;

    private EmailColaborador emailColaborador;

    private Servico servico;

    private UrgenciaPedido urgenciaPedido;

    private EstadoPedido estadoPedido;

    private DataLimitePedido dataLimite;
    private DataHoraSolicitacao dataHoraSolicitacao;


    public DataHoraSolicitacao dataHoraSolicitacao() {
        return dataHoraSolicitacao;
    }

    public PedidoDTO(NivelCriticidade nivelCriticidade, EmailColaborador emailColaborador, Servico servico, UrgenciaPedido urgenciaPedido, EstadoPedido estadoPedido, DataLimitePedido dataLimite, DataHoraSolicitacao dataHoraSolicitacao) {
        this.nivelCriticidade = nivelCriticidade;
        this.emailColaborador = emailColaborador;
        this.servico = servico;
        this.urgenciaPedido = urgenciaPedido;
        this.estadoPedido = estadoPedido;
        this.dataLimite = dataLimite;
        this.dataHoraSolicitacao = dataHoraSolicitacao;
    }

    @Override
    public String toString() {
        return "Pedido: \n" +
                "Email Colaborador " + emailColaborador + "\n"+
                "Servico: " + servico + "\n" +
                "Urgencia Pedido : " + urgenciaPedido + "\n"+
                "Estado Pedido: " + estadoPedido + "\n"+
                "Data Limite : " + dataLimite + "\n" +
                "Data E hora de solicitacao " + dataHoraSolicitacao + "\n";
    }
}
