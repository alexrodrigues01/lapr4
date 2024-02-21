package eapli.base.servicomanagement.repositories;

import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface ServicoRepository extends DomainRepository<Long, Servico> {

    public List<Servico> getServicos();

}
