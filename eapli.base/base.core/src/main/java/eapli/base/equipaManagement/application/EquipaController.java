package eapli.base.equipaManagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.equipaManagement.domain.TipoEquipa;
import eapli.base.equipaManagement.repositories.EquipaRepository;
import eapli.base.equipaManagement.repositories.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.repositories.TransactionalContext;

import java.util.LinkedList;
import java.util.List;

public class EquipaController {
    private EquipaRepository equipaRepository;
    private TipoEquipaRepository tipoEquipaRepository;

    private List<TipoEquipa> listaTiposEquipa=new LinkedList<>();

    private Equipa equipa;
    private TransactionalContext ctx;

    public EquipaController() {
        ctx = PersistenceContext.repositories().newTransactionalContext();
        equipaRepository=PersistenceContext.repositories().equipas(ctx);
        tipoEquipaRepository = PersistenceContext.repositories().tiposEquipa(ctx);
    }

    public Equipa novaEquipa(String identificadorUnico, String acronimoUnico, String descricao){
        return equipa= new Equipa(identificadorUnico, acronimoUnico, descricao);
    }

    public List<TipoEquipa> getTiposEquipa(){
        Iterable<TipoEquipa> tipoEquipaIterable=tipoEquipaRepository.findAll();
        for(TipoEquipa tipoEquipa : tipoEquipaIterable){
            listaTiposEquipa.add(tipoEquipa);
        }
        return listaTiposEquipa;
    }

    public void adicionarTipoEquipa(String codigoUnico) {
        TipoEquipa tipoEquipa = getTipoEquipaByCodigoUnico(codigoUnico);
        equipa.adicionarTipoEquipa(tipoEquipa);
    }

    private TipoEquipa getTipoEquipaByCodigoUnico(String codigoUnico) {
        for (TipoEquipa tp : listaTiposEquipa) {
            if (tp.codigoUnicoInterno().equalsIgnoreCase(codigoUnico)) {
                return tp;
            }
        }
        return null;
    }

    public void registarEquipa() {
        ctx.beginTransaction();
        equipaRepository.save(equipa);
        ctx.commit();
    }
}
