package eapli.base.nivelcriticidademanagement.application;

import eapli.base.catalogomanagement.domain.Objetivo;
import eapli.base.catalogomanagement.repositories.ObjetivoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.nivelcriticidademanagement.repositories.NivelCriticidadeRepository;
import eapli.framework.domain.repositories.TransactionalContext;

import java.util.ArrayList;
import java.util.List;

public class DefinirNiveisCriticidadeController {

    private TransactionalContext ctx;

    private NivelCriticidadeRepository nivelCriticidadeRepository;
    private ObjetivoRepository objetivoRepository;

    private List<NivelCriticidade> niveis;
    private NivelCriticidade nivel;

    public DefinirNiveisCriticidadeController() {
        ctx = PersistenceContext.repositories().newTransactionalContext();
        nivelCriticidadeRepository = PersistenceContext.repositories().nivelCriticidade(ctx);
        objetivoRepository = PersistenceContext.repositories().objetivos(ctx);
        niveis = new ArrayList<>();
    }

    public NivelCriticidade novoNivel(int escalaNumerica, String cor, String label){
        NivelCriticidade nivel = new NivelCriticidade(escalaNumerica, cor, label);
        niveis.add(nivel);
//        int idx = escalaNumerica - 1;
//        return niveis.get(idx);
        return nivel;
    }

    public Objetivo definirObjetivo(int idx, double tempoMaximoAprovacao, double tempoMedioAprovacao, double tempoMaximoResolucao, double tempoMedioResolucao){
        Objetivo objetivo = new Objetivo(tempoMaximoAprovacao, tempoMedioAprovacao, tempoMaximoResolucao, tempoMedioResolucao);

        idx--;

        niveis.get(idx).definirObjetivo(objetivo);

        return objetivo;
    }

    public Objetivo definirObjetivo2(NivelCriticidade nivel, double tempoMaximoAprovacao, double tempoMedioAprovacao, double tempoMaximoResolucao, double tempoMedioResolucao){
        Objetivo objetivo = new Objetivo(tempoMaximoAprovacao, tempoMedioAprovacao, tempoMaximoResolucao, tempoMedioResolucao);

        for(NivelCriticidade n : niveis){
            if(n.equals(nivel)){
                n.definirObjetivo(objetivo);
            }
        }

        return objetivo;
    }

    public void registarNiveisEObjetivos(){
        ctx.beginTransaction();

        for(NivelCriticidade nc : niveis){
            //Objetivo obj = nc.objetivo();

            nivelCriticidadeRepository.save(nc);
            //objetivoRepository.save(obj);
        }

        ctx.commit();
    }
}
