package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Objetivo;
import eapli.base.catalogomanagement.domain.SLA;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.catalogomanagement.repositories.ObjetivoRepository;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.equipaManagement.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.nivelcriticidademanagement.repositories.NivelCriticidadeRepository;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import eapli.framework.domain.repositories.TransactionalContext;

import java.util.LinkedList;
import java.util.List;

public class CriarCatalogoController {
    private CatalogoRepository catalogoRepository;
    private ServicoRepository servicoRepository;
    private List<Servico> listaServicos=new LinkedList<>();
    private ObjetivoRepository objetivoRepository;
    private ColaboradorRepository colaboradorRepository;
    private List<Colaborador> listaColaboradores=new LinkedList<>();
    private EquipaRepository equipaRepository;
    private NivelCriticidadeRepository nivelCriticidadeRepository;
    private List<Equipa> listaEquipas= new LinkedList<>();
    private TransactionalContext ctx;
    private Catalogo catalogo;
    private List<Objetivo> objetivos;
    private SLA contrato;


    public CriarCatalogoController() {
        ctx=PersistenceContext.repositories().newTransactionalContext();
        catalogoRepository = PersistenceContext.repositories().catalogos(ctx);
        servicoRepository = PersistenceContext.repositories().servicos();
        colaboradorRepository = PersistenceContext.repositories().colaboradores();
        equipaRepository = PersistenceContext.repositories().equipas();
        nivelCriticidadeRepository=PersistenceContext.repositories().nivelCriticidade(ctx);
        objetivoRepository = PersistenceContext.repositories().objetivos(ctx);
        objetivos= new LinkedList<>();
    }

    public Catalogo novoCatalogo(String iconeCatalogo, String descricaoCompleta, String descricaoSimples, String titulo, String identificadorUnico, String criterioAcesso) {
        this.catalogo = new Catalogo(iconeCatalogo, descricaoCompleta, descricaoSimples, titulo, identificadorUnico, criterioAcesso);
        return catalogo;
    }

    public List<Servico> getServicos() {
        Iterable<Servico> colaboradorIterable= servicoRepository.findAll();
        for (Servico c: colaboradorIterable) {
            listaServicos.add(c);
        }
        return listaServicos;
    }

    public boolean adicionarServico(String codigoUnico) {
        Servico servico = getServicoByCodigoUnico(codigoUnico);
        return catalogo.adicionarServico(servico);
    }

    private Servico getServicoByCodigoUnico(String codigoUnico) {
        for (Servico s : listaServicos) {
            if (s.codigo().equalsIgnoreCase(codigoUnico)) {
                return s;
            }
        }
        return null;
    }

    public void definirContratoSLA(String descricaoSla,int escalaNumerica, String cor, String etiqueta, List<List<Double>> dadosObjetivos){
        List<Objetivo> objetivos= new LinkedList<>();
        for(List<Double> tempos : dadosObjetivos){
            objetivos.add(new Objetivo(tempos.get(0),tempos.get(1),tempos.get(2),tempos.get(3)));
        }
        NivelCriticidadeRepository nivelCriticidadeRepository= PersistenceContext.repositories().nivelCriticidade();
        Iterable<NivelCriticidade> niveis= nivelCriticidadeRepository.findAll();
        NivelCriticidade nivelCriticidade=null;
        for(NivelCriticidade nivelCriticidade1: niveis){
            nivelCriticidade=nivelCriticidade1;
            break;
        }
        contrato= new SLA(descricaoSla,nivelCriticidade);
        catalogo.definirContrato(contrato);

    }

    public boolean adicionarObjetivo(double tempoMaximoAprovacao, double tempoMedioAprovacao, double tempoMaximoResolucao, double tempoMedioResolucao) {
        Objetivo objetivo = new Objetivo(tempoMaximoAprovacao, tempoMedioAprovacao, tempoMaximoResolucao, tempoMedioResolucao);
        objetivos.add(objetivo);
        return catalogo.adicionarObjetivo(objetivo);
    }

    public List<Colaborador> getColaboradores() {
        Iterable<Colaborador> colaboradorIterable= colaboradorRepository.findAll();
        for (Colaborador c: colaboradorIterable) {
            listaColaboradores.add(c);
        }
        return listaColaboradores;
    }

    public void adicionarColaborador(String email) {
        Colaborador colaborador = getColaboradorByEmail(email);
        catalogo.adicionarColaborador(colaborador);
    }


    private Colaborador getColaboradorByEmail(String email) {
        for (Colaborador c : listaColaboradores) {
            if (c.email().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }


    public List<Equipa> getEquipas() {
        Iterable<Equipa> colaboradorIterable= equipaRepository.findAll();
        for (Equipa c: colaboradorIterable) {
            listaEquipas.add(c);
        }
        return listaEquipas;
    }

    public boolean adicionarEquipa(String  identficadorUnico) {
        Equipa equipa = getEquipaByIdentificador(identficadorUnico);
        return catalogo.adicionarEquipa(equipa);
    }

    private Equipa getEquipaByIdentificador(String identficadorUnico) {
        for(Equipa equipa : listaEquipas){
            if(equipa.identificadorUnico().equalsIgnoreCase(identficadorUnico)){
                return equipa;
            }
        }
        return null;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void registarCatalogo() {
        ctx.beginTransaction();

        catalogoRepository.save(catalogo);
        ctx.commit();
    }
}
