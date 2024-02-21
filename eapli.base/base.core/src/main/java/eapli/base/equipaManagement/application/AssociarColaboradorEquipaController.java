package eapli.base.equipaManagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.equipaManagement.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.repositories.TransactionalContext;

import java.util.LinkedList;
import java.util.List;

public class AssociarColaboradorEquipaController {

    private List<Colaborador> listaColaboradores=new LinkedList<>();
    private List<Colaborador> listaColaboradoresEquipa=new LinkedList<>();
    private List<Equipa> listaEquipas= new LinkedList<>();
    private ColaboradorRepository colaboradorRepository;
    private EquipaRepository equipaRepository;
    private TransactionalContext ctx;

    private Equipa equipa;

    public AssociarColaboradorEquipaController() {
        ctx = PersistenceContext.repositories().newTransactionalContext();
        colaboradorRepository= PersistenceContext.repositories().colaboradores();
        equipaRepository=PersistenceContext.repositories().equipas();
    }

    public List<Colaborador> getColaboradores(){
        Iterable<Colaborador> colaboradorIterable= colaboradorRepository.findAll();
        for (Colaborador c: colaboradorIterable) {
            listaColaboradores.add(c);
        }
        return listaColaboradores;
    }

    public List<Equipa> getEquipas() {
        Iterable<Equipa> colaboradorIterable= equipaRepository.findAll();
        for (Equipa c: colaboradorIterable) {
            listaEquipas.add(c);
        }
        return listaEquipas;
    }

    public void adicionarColaboradorEquipa(String email, String identificadorUnico){
        Colaborador colaborador= getColaboradorByEmail(email,listaColaboradores);
        equipa=getEquipaByIdentificador(identificadorUnico);
        equipa.adicionarColaborador(colaborador);
    }

    public List<Colaborador> getColaboradoresEquipa(){
        return listaColaboradoresEquipa=equipa.getColaboradores();
    }

//    public void adicionarColaboradorResponsavel(String email){
//        Colaborador colaboradorResponsavel= getColaboradorByEmail(email,listaColaboradoresEquipa);
//        equipa.adicionarColaboradorResponsavel(colaboradorResponsavel);
//    }

    private Colaborador getColaboradorByEmail(String email, List<Colaborador> lista) {
        for (Colaborador c : lista) {
            if (c.email().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }

    private Equipa getEquipaByIdentificador(String identificadorUnico) {
        for(Equipa equipa : listaEquipas){
            if(equipa.identificadorUnico().equalsIgnoreCase(identificadorUnico)){
                return equipa;
            }
        }
        return null;
    }

    public void registarColaboradoresEquipa() {
        //ctx.beginTransaction();
        equipaRepository.save(equipa);
        //ctx.commit();
    }
}
