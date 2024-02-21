package eapli.base.equipaManagement.application;

import eapli.base.equipaManagement.domain.TipoEquipa;
import eapli.base.equipaManagement.repositories.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class TipoEquipaController {

    private TipoEquipaRepository tipoEquipaRepository;
    private TipoEquipa tipoEquipa;

    public TipoEquipaController() {
        tipoEquipaRepository= PersistenceContext.repositories().tiposEquipa();
    }

    public TipoEquipa novoTipoEquipa(String codigoUnico, String descricao, String cor){
        return tipoEquipa= new TipoEquipa(codigoUnico,descricao,cor);
    }

    public void registarTipoEquipa(){
        tipoEquipaRepository.save(tipoEquipa);
    }
}
