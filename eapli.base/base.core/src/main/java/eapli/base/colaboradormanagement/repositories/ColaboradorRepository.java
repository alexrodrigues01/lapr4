package eapli.base.colaboradormanagement.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface ColaboradorRepository extends DomainRepository<Integer,Colaborador> {

    List<Colaborador> getColaboradores();

    Optional<Colaborador> getColaboradorByEmail(String email);

}
