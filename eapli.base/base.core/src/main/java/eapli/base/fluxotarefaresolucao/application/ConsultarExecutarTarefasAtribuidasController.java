package eapli.base.fluxotarefaresolucao.application;

import eapli.base.Application;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovResDTO;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecResDTO;
import eapli.base.fluxotarefaresolucao.repositories.TarefaAprovResRepository;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.*;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import gramaticas.formulario.ValidacaoFormulario;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConsultarExecutarTarefasAtribuidasController {

    List<TarefaAprovRes> listaTarefasAprovacao;
    List<TarefaExecRes> listaTarefasExecucao;
    TarefaAprovResRepository tarefaAprovResRepository;
    TarefaExecResRepository tarefaExecResRepository;
    TarefaAprovRes tarefaAprovRes;
    TarefaExecRes tarefaExecRes;
    Formulario formulario;
    FormularioP formularioPreenchido;

    public ConsultarExecutarTarefasAtribuidasController() {
        tarefaAprovResRepository = PersistenceContext.repositories().tarefaAprovRes();
        tarefaExecResRepository = PersistenceContext.repositories().tarefaExecRes();
        listaTarefasAprovacao = new LinkedList<>();
        listaTarefasExecucao = new LinkedList<>();
    }

    public String getEmailColaboradorAtivo(){
        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession userSession = authz.session().orElseThrow(IllegalStateException::new);
        SystemUser systemUser = userSession.authenticatedUser();
        EmailAddress email = systemUser.email();

        return email.toString();
    }

    public List<TarefaExecResDTO> getTarefasAtribuidasExecucao(){
        listaTarefasExecucao = tarefaExecResRepository.getTarefasByEmailColabWithEstado(getEmailColaboradorAtivo(),TarefaExecRes.EstadoTarefaExecucao.Atribuida);
        List<TarefaExecResDTO> listDTO = new ArrayList<>();
        listaTarefasExecucao.forEach(te->listDTO.add(te.toDTO()));
        return listDTO;
    }

    public List<TarefaAprovResDTO> getTarefasAtribuidasAprovacao(){
        listaTarefasAprovacao = tarefaAprovResRepository.getTarefasColaboradorPendentes(getEmailColaboradorAtivo(),TarefaAprovRes.EstadoTarefaAprovacao.Atribuida);
        List<TarefaAprovResDTO> listDTO = new ArrayList<>();
        listaTarefasAprovacao.forEach(ta->listDTO.add(ta.toDTO()));
        return listDTO;
    }

    /**
     *
     * @param id
     * @return true se aprovacao
     */
    public boolean setTarefa(String id){
        for(TarefaAprovRes ta : listaTarefasAprovacao){
            if(ta.identity()==Long.parseLong(id)){
                tarefaAprovRes=ta;
                formulario=tarefaAprovRes.tarefaAprovacao().formulario();
                return true;
            }
        }

        for(TarefaExecRes te : listaTarefasExecucao){
            if(te.identity()==Long.parseLong(id)){
                tarefaExecRes=te;
                formulario=tarefaExecRes.tarefaExecucao().formulario();
                return false;
            }
        }
        return false;
    }

    public Formulario getFormulario(){
        return formulario;
    }

    public FormularioP guardarDadosFormularioAprov(List<String> respostas) {
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

        tarefaAprovRes.definirFormularioPreenchido(formularioPreenchido);

        return formularioPreenchido;
    }

    public FormularioP guardarDadosFormularioExec(List<String> respostas) {
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
        }else {
            if (validacaoFormulario.validarFormularioListener(formularioPreenchido).equalsIgnoreCase("OK")) {

            } else {
                return null;
            }
        }
        tarefaExecRes.definirFormularioPreenchido(formularioPreenchido);

        return formularioPreenchido;
    }

    public void registarResolucaoAprov(String aprov){
        if(aprov.equals("1")){
            tarefaAprovRes.setEstado(TarefaAprovRes.EstadoTarefaAprovacao.Aprovada);
            tarefaAprovResRepository.save(tarefaAprovRes);
        }else if(aprov.equals("0")){
            tarefaAprovRes.setEstado(TarefaAprovRes.EstadoTarefaAprovacao.Rejeitada);
            tarefaAprovResRepository.save(tarefaAprovRes);
        }
    }

    public void registarResolucaoExec(){
        tarefaExecRes.setEstado(TarefaExecRes.EstadoTarefaExecucao.Concluida);
        tarefaExecResRepository.save(tarefaExecRes);
    }
}
