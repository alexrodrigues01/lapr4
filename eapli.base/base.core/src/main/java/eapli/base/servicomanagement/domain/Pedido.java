package eapli.base.servicomanagement.domain;

import eapli.base.fluxotarefaresolucao.domain.FluxoResolucao;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;



@Entity
public class Pedido implements AggregateRoot<String> {

    @Id
    private String id;

    @OneToOne
    private NivelCriticidade nivelCriticidade;


    private EmailColaborador emailColaborador;

    @OneToOne
    private Servico servico;

    private UrgenciaPedido urgenciaPedido;


    private DataLimitePedido dataLimite;

    @ElementCollection
    private List<PathFile> pathFiles;

    @OneToOne(cascade = CascadeType.ALL)
    private FormularioP formulario;

    private DataHoraSolicitacao dataHoraSolicitacao;

    private EstadoPedido estadoPedido;

    @OneToOne(cascade= CascadeType.ALL)
    private FluxoResolucao fluxoResolucao;

    public Pedido() {
    }

    public Pedido(String id, NivelCriticidade nivelCriticidade, EmailColaborador emailColaborador, Servico servico, UrgenciaPedido urgenciaPedido, DataLimitePedido dataLimitePedido, FluxoResolucao fluxoResolucao) {
        this.id = id;
        this.nivelCriticidade = nivelCriticidade;
        this.emailColaborador = emailColaborador;
        this.servico = servico;
        this.urgenciaPedido = urgenciaPedido;
        this.dataLimite = dataLimitePedido;
        this.pathFiles=new LinkedList<>();
        this.fluxoResolucao = fluxoResolucao;
    }

    public List<PathFile> getPathFiles() {
        return pathFiles;
    }

    public boolean adicionarFicheiro(PathFile pathFile){
        return pathFiles.add(pathFile);
    }

    public void definirFormulario(FormularioP formulario){
        this.formulario=formulario;
    }

    public void guardarDataHoraSolicitacao(DataHoraSolicitacao dataHoraSolicitacao){
        this.dataHoraSolicitacao=dataHoraSolicitacao;
    }

    public void definirEstado(EstadoPedido estadoPedido){
        this.estadoPedido= estadoPedido;
    }

    public FluxoResolucao fluxoResolucao(){
        return fluxoResolucao;
    }

    public NivelCriticidade getNivelCriticidade() {
        return nivelCriticidade;
    }

    public DataLimitePedido getDataLimite() {
        return dataLimite;
    }

    public FormularioP getFormulario() {
        return formulario;
    }

    public DataHoraSolicitacao getDataHoraSolicitacao() {
        return dataHoraSolicitacao;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public Servico servico(){
        return servico;
    }

    public EmailColaborador emailColaborador(){
        return emailColaborador;
    }
    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public String identity() {
        return id;
    }

    public PedidoDTO toDTO(){
        return new PedidoDTO(nivelCriticidade,emailColaborador,servico,urgenciaPedido,estadoPedido,dataLimite,dataHoraSolicitacao);
    }

    public void definirFluxoResolucao(FluxoResolucao fluxoResolucao){
        this.fluxoResolucao=fluxoResolucao;
    }

    public void mudarEstadoTarefaDoing() {
        fluxoResolucao.tarefaExecucaoResolucao().doing();

    }

    public void mudarEstadoTarefaDone() {
        fluxoResolucao.tarefaExecucaoResolucao().done();
    }

    public void mudarEstadoTarefaPendente() {
        fluxoResolucao.tarefaExecucaoResolucao().pendente();
    }
}
