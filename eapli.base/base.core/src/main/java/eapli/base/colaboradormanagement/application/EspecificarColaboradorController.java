package eapli.base.colaboradormanagement.application;


import Utils.PasswordGenerator;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EspecificarColaboradorController {

    private ColaboradorRepository colaboradorRepository;
    private Colaborador colaborador;
    private Colaborador responsavel = null;
    private UserRepository userRepository;
    private TransactionalContext ctx;
    private List<Colaborador> colaboradores;

    public EspecificarColaboradorController() {
        ctx = PersistenceContext.repositories().newTransactionalContext();
        colaboradorRepository = PersistenceContext.repositories().colaboradores(ctx);
        userRepository = PersistenceContext.repositories().users(ctx);
    }

    public Colaborador novoColaborador(String email, String nomeComum, String nomeCompleto, String localResidencia, String telemovel, String dataNascimento, String funcao) {
        String[] parts = dataNascimento.split("-");
        Colaborador.Funcao role=Colaborador.getFuncao(funcao);
        return colaborador = new Colaborador(email, nomeComum, nomeCompleto, localResidencia, telemovel, LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])), role, responsavel);
    }

    public List<Colaborador> getColaboradores() {
        List<Colaborador> listaColaboradores= new ArrayList<>();
        Iterable<Colaborador> colaboradorIterable= colaboradorRepository.findAll();
        for (Colaborador c: colaboradorIterable) {
            listaColaboradores.add(c);
        }
        return colaboradores= listaColaboradores;
    }

    public boolean registarColaborador() {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername(colaborador.email()).withPassword(PasswordGenerator.gerarPassword()).withName(colaborador.firstName(),colaborador.lastName())
                .withEmail(colaborador.email()).withRoles(BaseRoles.USER);
        final SystemUser newUser = userBuilder.build();
        try {
            assert newUser != null;
            ctx.beginTransaction();
            userRepository.save(newUser);
            colaboradorRepository.save(colaborador);
            ctx.commit();
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            return false;
        }
    }

    public boolean registarGestor() {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("gestor").withPassword("Password1").withName(colaborador.firstName(),colaborador.lastName())
                .withEmail(colaborador.email()).withRoles(BaseRoles.GESTOR_HELPDESK);
        final SystemUser newUser = userBuilder.build();
        try {
            assert newUser != null;
            ctx.beginTransaction();
            userRepository.save(newUser);
            colaboradorRepository.save(colaborador);
            ctx.commit();
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            return false;
        }
    }

    public Colaborador getColaboradorById(String email) {
        for (Colaborador c : colaboradores) {
            if (c.email().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }

    public Colaborador.Funcao[] getFuncoes() {
        return Colaborador.funcoes();
    }
}
