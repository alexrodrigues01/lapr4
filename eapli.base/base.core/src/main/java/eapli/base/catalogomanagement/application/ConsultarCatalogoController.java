package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConsultarCatalogoController {
    List<Catalogo> listaCatalogosColaborador = new LinkedList<>();

    public List<Catalogo> getCatalogos() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession userSession = authz.session().orElseThrow(IllegalStateException::new);
        SystemUser systemUser = userSession.authenticatedUser();
        EmailAddress email = systemUser.email();
        CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogos();
        Iterable<Catalogo> it=catalogoRepository.findAll();
        List<Catalogo> listaCatalogos = new ArrayList<>();
        for (Catalogo catalogo:it) {
            listaCatalogos.add(catalogo);
        }
        return getCatalogosColaborador(email, listaCatalogos);
    }

    private List<Catalogo> getCatalogosColaborador(EmailAddress emailAddress, List<Catalogo> catalogos) {
        for (Catalogo c : catalogos) {
            for (Equipa e : c.equipas()) {
                for (Colaborador colab : e.getColaboradores()) {
                    if (colab.email().equalsIgnoreCase(emailAddress.toString())) {
                        listaCatalogosColaborador.add(c);
                    }
                }
            }
        }
        return listaCatalogosColaborador;
    }

    public Catalogo getCatalogobyTitulo(String tituloCatalogo) {
        for (Catalogo c : listaCatalogosColaborador) {
            if (c.tituloCatologo().equalsIgnoreCase(tituloCatalogo))
                return c;
        }
        return null;
    }

    public Catalogo getCatalogobyIdentificador(String identificadorUnico) {
        for (Catalogo c : listaCatalogosColaborador) {
            if (c.identificadorUnico().equalsIgnoreCase(identificadorUnico))
                return c;
        }

        return null;
    }

    public Servico getServicoByTitulo(String tituloServico) {
        for (Catalogo c : listaCatalogosColaborador) {
            for (Servico s : c.servicos()) {
                if (s.titulo().equalsIgnoreCase(tituloServico))
                    return s;
            }
        }
        return null;
    }

    public Servico getServicoByKeyword(String keyword) {
        for (Catalogo c : listaCatalogosColaborador) {
            for (Servico s : c.servicos()) {
                for(Keyword k: s.keywords()){
                    if(k.keyword().equalsIgnoreCase(keyword))
                        return s;
                }
            }
        }
        return null;
    }
}
