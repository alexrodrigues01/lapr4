package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovResDTO;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecResDTO;
import eapli.base.fluxotarefaresolucao.repositories.TarefaAprovResRepository;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Pedido;
import eapli.base.servicomanagement.repositories.PedidoRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConsultarReivindicarTarefasPendentesController {
    List<TarefaAprovRes> listaTarefasAprovacao;
    List<TarefaExecRes> listaTarefasExecucao;
    ColaboradorRepository colaboradorRepository;
    PedidoRepository pedidoRepository;
    TarefaAprovResRepository tarefaAprovResRepository;
    TarefaExecResRepository tarefaExecResRepository;
    Pedido pedido;

    public ConsultarReivindicarTarefasPendentesController() {
        pedidoRepository = PersistenceContext.repositories().pedido();
        colaboradorRepository = PersistenceContext.repositories().colaboradores();
        tarefaAprovResRepository = PersistenceContext.repositories().tarefaAprovRes();
        tarefaExecResRepository = PersistenceContext.repositories().tarefaExecRes();
        listaTarefasAprovacao = new LinkedList<>();
        listaTarefasExecucao = new LinkedList<>();
    }

    public List<Pedido> getPedidos(){
        Iterable<Pedido> it = pedidoRepository.findAll();
        List<Pedido> listaPedidos = new ArrayList<>();
        for(Pedido p : it){
            listaPedidos.add(p);
        }
        return listaPedidos;
    }

    public Colaborador getColaboradorAtivo(){
        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession userSession = authz.session().orElseThrow(IllegalStateException::new);
        SystemUser systemUser = userSession.authenticatedUser();
        EmailAddress email = systemUser.email();

        return colaboradorRepository.getColaboradorByEmail(email.toString()).get();
    }

    public boolean isGestor(){
        AuthorizationService authz = AuthzRegistry.authorizationService();
        return authz.isAuthenticatedUserAuthorizedTo(BaseRoles.GESTOR_HELPDESK);
    }

    public Colaborador getColaboradorPedido(String email){
        return colaboradorRepository.getColaboradorByEmail(email).get();
    }

    public List<TarefaExecResDTO> getTarefasPendentesExecucao(){
        if(!isGestor()) {
            for (Pedido p : getPedidos()) {
                if(p.fluxoResolucao().tarefaAprovacaoResolucao()!=null){
                    for (Equipa e : p.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().equipas()) {
                        for (Colaborador c : e.getColaboradores()) {
                            if (c.equals(getColaboradorAtivo()) && p.fluxoResolucao().tarefaExecucaoResolucao().estado() == TarefaExecRes.EstadoTarefaExecucao.Pendente
                                    && p.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().manual()
                                    && p.fluxoResolucao().tarefaAprovacaoResolucao().estado() == TarefaAprovRes.EstadoTarefaAprovacao.Aprovada) {
                                listaTarefasExecucao.add(p.fluxoResolucao().tarefaExecucaoResolucao());
                                pedido = p;
                            }
                        }
                    }
                }else{
                    for (Equipa e : p.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().equipas()) {
                        for (Colaborador c : e.getColaboradores()) {
                            if (c.equals(getColaboradorAtivo()) && p.fluxoResolucao().tarefaExecucaoResolucao().estado() == TarefaExecRes.EstadoTarefaExecucao.Pendente
                                    && p.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().manual()) {
                                listaTarefasExecucao.add(p.fluxoResolucao().tarefaExecucaoResolucao());
                                pedido = p;
                            }
                        }
                    }
                }
            }
        }
        List<TarefaExecResDTO> listDTO = new ArrayList<>();
        listaTarefasExecucao.forEach(te->listDTO.add(te.toDTO()));
        return listDTO;
    }

    public List<TarefaAprovResDTO> getTarefasPendentesAprovacao(){
        for(Pedido p: getPedidos()){
            if(p.fluxoResolucao().tarefaAprovacaoResolucao()!=null){
                if(isGestor() && p.fluxoResolucao().tarefaAprovacaoResolucao().estado() == TarefaAprovRes.EstadoTarefaAprovacao.Pendente
                        && !p.fluxoResolucao().tarefaAprovacaoResolucao().tarefaAprovacao().isResponsavelHierarquico()){
                    listaTarefasAprovacao.add(p.fluxoResolucao().tarefaAprovacaoResolucao());
                    pedido=p;
                }else if(getColaboradorAtivo().equals(getColaboradorPedido(p.emailColaborador().emailColaborador()).responsavel())
                        && p.fluxoResolucao().tarefaAprovacaoResolucao().estado() == TarefaAprovRes.EstadoTarefaAprovacao.Pendente
                        && p.fluxoResolucao().tarefaAprovacaoResolucao().tarefaAprovacao().isResponsavelHierarquico()){
                    listaTarefasAprovacao.add(p.fluxoResolucao().tarefaAprovacaoResolucao());
                    pedido=p;
                }
            }
        }
        List<TarefaAprovResDTO> listDTO = new ArrayList<>();
        listaTarefasAprovacao.forEach(ta->listDTO.add(ta.toDTO()));
        return listDTO;
    }

    public void reivindicarTarefa(String id){
        for(TarefaAprovRes ta : listaTarefasAprovacao){
            if(ta.identity()==Long.parseLong(id)){
                ta.definirColaboradorAtribuido(getColaboradorAtivo());
                ta.setEstado(TarefaAprovRes.EstadoTarefaAprovacao.Atribuida);
                registarReivindicacao();
            }
        }

        for(TarefaExecRes te : listaTarefasExecucao){
            if(te.identity()==Long.parseLong(id)){
                te.definirColaboradorAtribuido(getColaboradorAtivo());
                te.setEstado(TarefaExecRes.EstadoTarefaExecucao.Atribuida);
                registarReivindicacao();
            }
        }
    }

    public void registarReivindicacao(){
        pedidoRepository.save(pedido);
    }
}
