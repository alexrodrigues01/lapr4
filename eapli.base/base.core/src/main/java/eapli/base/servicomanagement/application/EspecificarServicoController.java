package eapli.base.servicomanagement.application;

import eapli.base.Application;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.equipaManagement.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import eapli.base.servicomanagement.domain.*;
import eapli.base.servicomanagement.repositories.*;

import eapli.base.tarefamanagement.domain.Script;
import eapli.base.tarefamanagement.domain.TarefaAprovacao;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import eapli.framework.domain.repositories.TransactionalContext;
import gramaticas.script.ValidarScript;

import java.util.*;

public class EspecificarServicoController {

    private TransactionalContext ctx;

    private ServicoRepository servicoRepository;

    private List<Keyword> keywords;
    private List<Atributo> atributos;

    private List<String> opcoesEscolhaMultipla;

    private Formulario formulario;

    private Servico servico;

    private List<Equipa> listaEquipas;
    private Set<Equipa> equipasEscolhidas;


    private TarefaAprovacao tarefaAprovacao;
    private List<Atributo> atributosFormularioAprovacao;


    private TarefaExecucao tarefaExecucao;
    private List<Atributo> atributosFormularioResolucao;

    public EspecificarServicoController() {
        ctx = PersistenceContext.repositories().newTransactionalContext();
        servicoRepository = PersistenceContext.repositories().servicos(ctx);

        keywords= new ArrayList<>();

        atributos= new ArrayList<>();
        opcoesEscolhaMultipla = new ArrayList<>();

        listaEquipas = new ArrayList<>();
        equipasEscolhidas = new HashSet<>();

        tarefaAprovacao = null;
        atributosFormularioAprovacao = new ArrayList<>();

        tarefaExecucao = null;
        atributosFormularioResolucao = new ArrayList<>();
    }

    public Servico novoServico(String codigo, String titulo, String descSimples, String descCompleta, List<Keyword> keywords){
        NomeServico nome = new NomeServico(titulo);
        CodigoServico c = new CodigoServico(codigo);

        servico = new Servico(nome, c, descSimples, descCompleta, keywords);
        return servico;
    }

    // metodos atributos

    public void adicionarAtributo(String nome, String label, String descricao, String exPressaoRegular, String tipoDados, boolean obrigatoriedade){
        addAtributo(nome, label, descricao, exPressaoRegular, tipoDados, obrigatoriedade, atributos);
    }

    public void adicionarAtributoAprovacao(String nome, String label, String descricao, String exPressaoRegular, String tipoDados, boolean obrigatoriedade){
        addAtributo(nome, label, descricao, exPressaoRegular, tipoDados, obrigatoriedade, atributosFormularioAprovacao);
    }

    public void adicionarAtributoResolucao(String nome, String label, String descricao, String exPressaoRegular, String tipoDados, boolean obrigatoriedade){
        addAtributo(nome, label, descricao, exPressaoRegular, tipoDados, obrigatoriedade, atributosFormularioResolucao);
    }

    private void addAtributo(String nome, String label, String descricao, String exPressaoRegular, String tipoDados, boolean obrigatoriedade, List<Atributo> atributos) {
        NomeAtributo na = new NomeAtributo(nome);
        Label labelx = new Label(label);
        DescricaoAtributo d = new DescricaoAtributo(descricao);
        ExpressaoRegular exp = new ExpressaoRegular(exPressaoRegular);
        TipoDados td = new TipoDados(tipoDados);

        Atributo atributo = new Atributo(na, labelx, d, exp, td, obrigatoriedade);

//        System.out.println(opcoesEscolhaMultipla.toString());

        if(!opcoesEscolhaMultipla.isEmpty()){
            atributo.definirOpcoes(opcoesEscolhaMultipla);
            opcoesEscolhaMultipla.clear();
        }

        atributos.add(atributo);
    }

    //formularios

    public void definirFormulario(String codigo, String nome){
        CodigoUnicoFormulario cuf = new CodigoUnicoFormulario(codigo);
        NomeFormulario nomeF = new NomeFormulario(nome);

        Formulario formulario = new Formulario(nomeF, cuf, atributos);
        servico.definirFormulario(formulario);
    }

    public void definirOpcoesEscolhaMultipla(List<String> opcoesEscolhaMultipla) {
        this.opcoesEscolhaMultipla = opcoesEscolhaMultipla;
    }

    public void criarTarefaAprovacao(String nomeF, String codigoF,  boolean responsavelHierarquico){
        CodigoUnicoFormulario cuf = new CodigoUnicoFormulario(codigoF);
        NomeFormulario n = new NomeFormulario(nomeF);
        Formulario formulario = new Formulario(n, cuf, atributosFormularioAprovacao);
        tarefaAprovacao = new TarefaAprovacao(formulario, responsavelHierarquico);
    }

    public List<Equipa> equipas(){
        EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
        Iterable<Equipa> equipas = equipaRepository.findAll();
        List<Equipa> list = new ArrayList<>();
        for(Equipa e : equipas){
            listaEquipas.add(e);
        }
        return listaEquipas;
    }

    public void selecionarEquipa(int index){
        index--;
        equipasEscolhidas.add(listaEquipas.get(index));
    }

    public boolean criarTarefaResolucao(boolean manual, String nomeF, String codigoF, Script script){
        if(manual){
            CodigoUnicoFormulario cuf = new CodigoUnicoFormulario(codigoF);
            NomeFormulario n = new NomeFormulario(nomeF);

            Formulario formulario = new Formulario(n, cuf, atributosFormularioResolucao);

            tarefaExecucao = new TarefaExecucao(true, equipasEscolhidas, formulario, null);
        }else{
            try {
                if(Application.settings().isVisitor()) {
                    ValidarScript.visitor(null, script, false);
                }else {
                    ValidarScript.listener(null,script,false);
                }
            }catch (Exception e){
                return false;
            }
            tarefaExecucao = new TarefaExecucao(false, equipasEscolhidas, null, script);
        }
        return true;
    }

    public void criarFluxoTarefa(){
        FluxoTarefa fluxo = new FluxoTarefa(tarefaExecucao, tarefaAprovacao);
        servico.definirFluxoTarefa(fluxo);
    }

    public boolean publicarServico(){
        return servico.verificarPublicacao();
    }

    public void registarServico(){
        ctx.beginTransaction();

        servicoRepository.save(servico);

        ctx.commit();
    }
}
