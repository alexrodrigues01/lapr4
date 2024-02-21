package eapli.base.servicomanagement.application;

import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.equipaManagement.repositories.EquipaRepository;
import eapli.base.servicomanagement.domain.*;
import eapli.base.servicomanagement.repositories.FormularioRepository;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.Script;
import eapli.base.tarefamanagement.domain.TarefaAprovacao;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import eapli.framework.domain.repositories.TransactionalContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class RetomarServicoController {

    List<Servico> listaServicos;
    List<Equipa> listaEquipa;
    List<Atributo> atributosTarefa;

    Servico servicoEscolhido;
    Servico servicoNovo;

    ServicoRepository servicoRepository;
    FormularioRepository formularioRepository;

    private TransactionalContext ctx;

    public RetomarServicoController() {
        ctx = PersistenceContext.repositories().newTransactionalContext();
        servicoRepository = PersistenceContext.repositories().servicos(ctx);
        formularioRepository = PersistenceContext.repositories().formularios(ctx);
        listaServicos = new ArrayList<>();
        listaEquipa = new ArrayList<>();
        servicoEscolhido = null;
        servicoNovo = null;
    }

    public List<Servico> getServicosPorPublicar(){
        Iterable<Servico> iterable = servicoRepository.findAll();
        for(Servico servico : iterable){
            if(!servico.publicacao()){
                listaServicos.add(servico);
            }
        }

        return listaServicos;
    }

    public Servico servicoByCodigo(String codigo){
        for(Servico servico : listaServicos){
            if(servico.codigo().equalsIgnoreCase(codigo)){
                servicoEscolhido = servico;
                servicoNovo = servicoEscolhido;
            }
        }
        return servicoEscolhido;
    }

    public boolean validarCodigo(String codigo) throws IllegalArgumentException{
        for(Servico servico : listaServicos){
            if(servico.codigo().equalsIgnoreCase(codigo) && !servico.equals(servicoEscolhido)){
                return false;
            }
        }
        return true;
    }

    public boolean validarNome(String nome) throws IllegalArgumentException{
        for(Servico servico : listaServicos){
            if(servico.titulo().equalsIgnoreCase(nome) && !servico.equals(servicoEscolhido)){
                return false;
            }
        }
        return true;
    }

    public void alterarDadosPrincipaisServico(String codigo, String nome, String descSimples, String descCompleta){

        if(!codigo.isBlank()){
            CodigoServico c = new CodigoServico(codigo);
//            servicoNovo.definirCodigo(c);
            servicoEscolhido.definirCodigo(c);
        }

        if(!nome.isBlank()){
            NomeServico n = new NomeServico(nome);
//            servicoNovo.definirNome(n);
            servicoEscolhido.definirNome(n);
        }

        if(!descSimples.isBlank()){
//            servicoNovo.definirDescSimples(descSimples);
            servicoEscolhido.definirDescSimples(descSimples);
        }

        if(!descCompleta.isBlank()){
//            servicoNovo.definirDescCompleta(descCompleta);
            servicoEscolhido.definirDescCompleta(descCompleta);
        }
    }

    public List<Keyword> keywords(){
//        return servicoNovo.keywords();
        return servicoEscolhido.keywords();
    }

    public void removerKeyword(String keyword){
        int index = 0;
        List<Keyword> lista = servicoEscolhido.keywords();
        for(Keyword key : lista){
            if(key.keyword().equalsIgnoreCase(keyword)){
                break;
            }
            index++;
        }
//        servicoNovo.keywords().remove(index);
        servicoEscolhido.keywords().remove(index);
    }

    public void adicionarKeyword(String keyword){
        Keyword key = new Keyword(keyword);
//        servicoNovo.definirKeyword(key);
        servicoEscolhido.definirKeyword(key);
    }

    public Formulario formulario(){
//        return servicoNovo.formulario();
        return servicoEscolhido.formulario();
    }

    public boolean validarCodigoFormulario(String codigo){
        Iterable<Formulario> iterable = formularioRepository.findAll();
        for(Formulario f : iterable){
            if(f.codigoUnicoFormulario().equalsIgnoreCase(codigo)){
                return false;
            }
        }
        return true;
    }

    public boolean validarNomeFormulario(String nome){
        Iterable<Formulario> iterable = formularioRepository.findAll();
        for(Formulario f : iterable){
            if(f.nome().equalsIgnoreCase(nome)){
                return false;
            }
        }
        return true;
    }

    public void definirNomeFormulario(String nome){
//        servicoNovo.formulario().definirNome(nome);
        servicoEscolhido.formulario().definirNome(nome);
    }

    public void definirCodigoFormulario(String codigo){
//        servicoNovo.formulario().definirCodigoUnico(codigo);
        servicoEscolhido.formulario().definirCodigoUnico(codigo);
    }

    public List<Atributo> atributosFormulario(){
//        return servicoNovo.formulario().atributos();
        return servicoEscolhido.formulario().atributos();
    }

    public boolean removerAtributo(String nomeAtributo){
//        return servicoNovo.formulario().removerAtributoByNome(nomeAtributo);
        return servicoEscolhido.formulario().removerAtributoByNome(nomeAtributo);
    }

    public void adicionarAtributo(String nome, String label, String descricao, String exPressaoRegular, String tipoDados, boolean obrigatoriedade) {
        NomeAtributo na = new NomeAtributo(nome);
        Label labelx = new Label(label);
        DescricaoAtributo d = new DescricaoAtributo(descricao);
        ExpressaoRegular exp = new ExpressaoRegular(exPressaoRegular);
        TipoDados td = new TipoDados(tipoDados);

        Atributo atributo = new Atributo(na, labelx, d, exp, td, obrigatoriedade);
//        servicoNovo.adicionarAtributoFormulario(atributo);
        servicoEscolhido.adicionarAtributoFormulario(atributo);
    }

    public Set<Equipa> equipasFluxo(){
//        FluxoTarefa fluxo = servicoNovo.fluxoTarefa();
        FluxoTarefa fluxo = servicoEscolhido.fluxoTarefa();
        TarefaExecucao res = fluxo.tarefaExecucao();
        return res.equipas();
    }

    public boolean removerEquipa(int index){
        index--;
//        FluxoTarefa fluxo = servicoNovo.fluxoTarefa();
        FluxoTarefa fluxo = servicoEscolhido.fluxoTarefa();

        TarefaExecucao res = fluxo.tarefaExecucao();
        TarefaAprovacao ap = fluxo.tarefaAprovacao();

        if(res.equipas().size() <= index || index < 0){
            return false;
        }

        res.equipas().remove(index);
        //ap.equipas().remove(index);

        return true;
    }

    public List<Equipa> equipas(){
        EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
        Iterable<Equipa> equipas = equipaRepository.findAll();
        List<Equipa> list = new ArrayList<>();
        for(Equipa e : equipas){
            list.add(e);
        }

        listaEquipa = list;

        return list;
    }

    public boolean adicionarEquipa(int index){
        index--;

        if(listaEquipa.size() <= index || index < 0){
            return false;
        }

        Equipa e = listaEquipa.get(index);

        if(servicoEscolhido.fluxoTarefa().tarefaExecucao().equipas().contains(e)){
            return false;
        }

//        FluxoTarefa fluxo = servicoNovo.fluxoTarefa();
        FluxoTarefa fluxo = servicoEscolhido.fluxoTarefa();

        TarefaExecucao res = fluxo.tarefaExecucao();
        TarefaAprovacao ap = fluxo.tarefaAprovacao();


        res.equipas().add(e);
        //ap.equipas().add(e);

        return true;
    }

    public void removerTarefaAprovacao(){
//        servicoNovo.fluxoTarefa().definirTarefaAprovacao(null);
        servicoEscolhido.fluxoTarefa().definirTarefaAprovacao(null);
    }

    public void criarTarefaAprovacao(){
        //por implementar
    }

    public void adicionarAtributoFormularioTarefaResolucao(String nomeAtributo, String label, String descricao, String expressaoRegular, String tipoDados, boolean obrigatoriedade){
        NomeAtributo na = new NomeAtributo(nomeAtributo);
        Label labelx = new Label(label);
        DescricaoAtributo d = new DescricaoAtributo(descricao);
        ExpressaoRegular exp = new ExpressaoRegular(expressaoRegular);
        TipoDados td = new TipoDados(tipoDados);

        Atributo atributo = new Atributo(na, labelx, d, exp, td, obrigatoriedade);
        atributosTarefa.add(atributo);
    }

    public void criarTarefaResolucao(boolean manual, String nomeF, String codigoF, Date deadline, Script script){
        if(manual){
            CodigoUnicoFormulario cuf = new CodigoUnicoFormulario(codigoF);
            NomeFormulario n = new NomeFormulario(nomeF);

            Formulario formulario = new Formulario(n, cuf, atributosTarefa);

            TarefaExecucao tarefaExecucao = new TarefaExecucao(true, servicoNovo.fluxoTarefa().tarefaExecucao().equipas(), formulario, null);
//            servicoNovo.fluxoTarefa().definirTarefaResolucao(tarefaExecucao);
            servicoEscolhido.fluxoTarefa().definirTarefaExecucao(tarefaExecucao);
        }else{
            TarefaExecucao tarefaExecucao = new TarefaExecucao(false, servicoNovo.fluxoTarefa().tarefaExecucao().equipas(), null, script);
//            servicoNovo.fluxoTarefa().definirTarefaResolucao(tarefaExecucao);
            servicoEscolhido.fluxoTarefa().definirTarefaExecucao(tarefaExecucao);
        }
    }

    public boolean publicarServico(){
//        return servicoNovo.verificarPublicacao();
        return servicoEscolhido.verificarPublicacao();
    }

    public void apagarServico(){
        ctx.beginTransaction();

        servicoRepository.remove(servicoEscolhido);

        ctx.commit();
    }

    public void registarServico(){
        ctx.beginTransaction();

//        servicoRepository.save(servicoNovo);
        servicoRepository.save(servicoEscolhido);

        ctx.commit();
    }






}
