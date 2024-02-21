package eapli.base.servicomanagement.application;

import eapli.base.Application;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.fluxotarefaresolucao.domain.FluxoResolucao;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
//import eapli.base.gramaticas.formulario.eapli.base.gramaticas.formulario.ValidacaoFormulario;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.servicomanagement.domain.*;
import eapli.base.servicomanagement.repositories.PedidoRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import gramaticas.formulario.ValidacaoFormulario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SolicitarServicoController {
    PedidoRepository pedidoRepository;
    CatalogoRepository catalogoRepository;
    List<Catalogo> listaCatalogosColaborador;
    List<Pedido> listaPedidos;
    Catalogo catalogo;
    Pedido pedido;
    String emailColaborador;
    Servico servico;
    LocalDateTime dataSolicitacao;
    Formulario formulario;
    FormularioP formularioPreenchido;


    public SolicitarServicoController() {
        pedidoRepository = PersistenceContext.repositories().pedido();
        listaCatalogosColaborador = new LinkedList<>();
        listaPedidos=new LinkedList<>();
    }

    public List<Catalogo> getCatalogos() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession userSession = authz.session().orElseThrow(IllegalStateException::new);
        SystemUser systemUser = userSession.authenticatedUser();
        emailColaborador = systemUser.email().toString();
        CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogos();
        Iterable<Catalogo> it = catalogoRepository.findAll();
        List<Catalogo> listaCatalogos = new ArrayList<>();
        for (Catalogo catalogo : it) {
            listaCatalogos.add(catalogo);
        }
        return getCatalogosColaborador(emailColaborador, listaCatalogos);
    }

    private List<Catalogo> getCatalogosColaborador(String emailAddress, List<Catalogo> catalogos) {
        for (Catalogo c : catalogos) {
            for (Equipa e : c.equipas()) {
                for (Colaborador colab : e.getColaboradores()) {
                    if (colab.email().equalsIgnoreCase(emailAddress.toString())) {
                        listaCatalogosColaborador.add(c);
                    }
                }
            }
        }
        return listaCatalogosColaborador;
    }

    public Servico getServicoByCodigoUnico(String codigoUnico) {
        for (Catalogo c : listaCatalogosColaborador) {
            for (Servico s : c.servicos()) {
                if (s.codigo().equalsIgnoreCase(codigoUnico)) {
                    catalogo= c;
                    return servico = s;
                }
            }
        }
        return null;
    }

    public boolean hasTarefaAprovacao(){
        if(servico.fluxoTarefa().tarefaAprovacao()!=null)
            return true;
        else
            return false;
    }

    public Pedido novoPedido(String urgenciaPedido, LocalDate dataLimitePedido, LocalDate dataLimTrfAprov, LocalDate dataLimTrfExec) {
        String idPedido = generateIdPedido();
        NivelCriticidade nivelCriticidade = catalogo.contrato().nivelCriticidade();
        return pedido = new Pedido(idPedido, nivelCriticidade, new EmailColaborador(emailColaborador.toString()), servico, new UrgenciaPedido(urgenciaPedido), new DataLimitePedido(dataLimitePedido),criarFluxoResolucao(dataLimTrfAprov,dataLimTrfExec));
    }

    public FluxoResolucao criarFluxoResolucao(LocalDate dataLimTrfAprov, LocalDate dataLimTrfExec){
        if(dataLimTrfAprov!=null){
            return new FluxoResolucao(new TarefaAprovRes(servico.fluxoTarefa().tarefaAprovacao(),dataLimTrfAprov),new TarefaExecRes(servico.fluxoTarefa().tarefaExecucao(),dataLimTrfExec));
        } else{
            return new FluxoResolucao(null, new TarefaExecRes(servico.fluxoTarefa().tarefaExecucao(),dataLimTrfExec));
        }
    }

    private String generateIdPedido() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        dataSolicitacao = LocalDateTime.now();
        int ano = dataSolicitacao.getYear();
        pedidoRepository=PersistenceContext.repositories().pedido();
        Iterable<Pedido> pedidoIterable = pedidoRepository.findAll();
        for (Pedido p : pedidoIterable) {
            listaPedidos.add(p);
        }
        if(listaPedidos.size()!=0){
            int ultimoPedidoID = 0;
            String idPedido;
            for (Pedido pedido : listaPedidos) {
                idPedido = pedido.identity();
                String partesId[] = idPedido.split("[/]");
                if (Integer.parseInt(partesId[0]) == ano) {
                    if (Integer.parseInt(partesId[1]) > ultimoPedidoID){
                        ultimoPedidoID = Integer.parseInt(partesId[1]);
                    }
                }
            }
            return String.format("%d/%d", ano, ultimoPedidoID + 1);
        }
        return String.format("%d/%d", ano, 1);
    }

    public boolean adicionarFicheiro(String pathFile) {
        return pedido.adicionarFicheiro(new PathFile(pathFile));
    }

    public Formulario getFormularioSolicitacao() {
        return formulario = servico.formulario();
    }


    public FormularioP guardarDadosFormularioSolicitacao(List<String> respostas) {
        List<AtributoPreenchido> atributoPreenchidos = new LinkedList<>();
        int i = 0;
        for (Atributo a : formulario.atributos()) {
            atributoPreenchidos.add(new AtributoPreenchido(new NomeAtributo(a.nome()), new Label(a.label()), new DescricaoAtributo(a.descricao()), new ExpressaoRegular(a.expressaoRegular()), new TipoDados(a.tipoDados()),a.obrigatoriedade(),new Resposta(respostas.get(i))));
            i++;
        }
        formularioPreenchido = new FormularioP(new NomeFormulario(formulario.nome()), atributoPreenchidos);
        ValidacaoFormulario validacaoFormulario= new ValidacaoFormulario();
        if(Application.settings().isVisitor()) {
            if (validacaoFormulario.validarFormularioVisitor(formularioPreenchido).equalsIgnoreCase("OK")) {

            } else {
                return null;
            }
        }else{
            if (validacaoFormulario.validarFormularioListener(formularioPreenchido).equalsIgnoreCase("OK")) {

            }else {
                return null;
            }
        }
        pedido.definirFormulario(formularioPreenchido);
        pedido.guardarDataHoraSolicitacao(new DataHoraSolicitacao(dataSolicitacao));
        pedido.definirEstado(new EstadoPedido(EstadoPedido.EstadoPedidoEnum.SUBMETIDO));
        return formularioPreenchido;
    }

    public void setListaCatalogosColaborador(List<Catalogo> listaCatalogosColaborador) {
        this.listaCatalogosColaborador = listaCatalogosColaborador;
    }

    public void setEmailColaborador(String emailColaborador) {
        this.emailColaborador = emailColaborador;
    }

    public void registarPedido() {
        pedidoRepository= PersistenceContext.repositories().pedido();
        pedidoRepository.save(pedido);
    }
}
