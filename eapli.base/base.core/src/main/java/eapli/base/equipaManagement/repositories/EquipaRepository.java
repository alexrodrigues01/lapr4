package eapli.base.equipaManagement.repositories;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface EquipaRepository extends DomainRepository<Long, Equipa> {

    List<Equipa> getEquipas();
}
