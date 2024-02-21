package eapli.base.infrastructure.bootstrapers;

import eapli.base.colaboradormanagement.application.EspecificarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipaManagement.application.AssociarColaboradorEquipaController;
import eapli.base.equipaManagement.application.EquipaController;
import eapli.base.equipaManagement.application.TipoEquipaController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class OrganizacaoBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(OrganizacaoBootstrapper.class);
    private EspecificarColaboradorController especificarColaboradorController = new EspecificarColaboradorController();
    private EquipaController equipaController = new EquipaController();
    private TipoEquipaController tipoEquipaController = new TipoEquipaController();
    private AssociarColaboradorEquipaController associarColaboradorEquipaController = new AssociarColaboradorEquipaController();

    @Override
    public boolean execute() {
        /* colaboradores*/
        registerColaborador("email1@email.pt","Ze","Jose dos Leitoes","Mealhada","911111555","2000-05-07", "DiretorComercial");
        registerColaborador("email2@email.pt","Rui","Rui dos Leitoes","Maia","911111556","1995-05-20", "GestorClientes");
        registerColaborador("email3@email.pt","Maria","Maria dos Leitoes","Porto","911111557","1990-04-05", "GestorClientes");
        registerColaborador("email4@email.pt","Manel","Manuel dos Leitoes","Lisboa","911111558","1950-12-10", "AssistenteDirecao");
        registerColaborador("email5@email.pt","Miguel","Miguel dos Leitoes","Vermoim","911111550","1980-09-03", "Comercial");
        registerColaborador("email6@email.pt","Ruben","Ruben dos Leitoes","Covelas","911111578","1957-11-10", "AssistenteDirecao");
        registerColaborador("email7@email.pt","Carlos","Carlos dos Leitoes","Leiria","911111568","1977-11-18", "Comercial");
        registerColaborador("email8@email.pt","Mo","Mohammed dos Leitoes","Dubai","912345678","2001-09-11", "DiretorComercial");
        /* tipos de equipa */
        registerTipoEquipa("455","RecursosHumanos","azul");
        registerTipoEquipa("147","Vendas","vermelho");

        /* equipas */

        registerEquipa("123","EQP1","Equipa RH1","455");
        registerEquipa("540","EQP2","Equipa Venda1","147");

        /* associar colaboradores à equipa*/
        registarColaboradoresEquipa("123","email1@email.pt");
        registarColaboradoresEquipa("540","email2@email.pt");
        registarColaboradoresEquipa("123","email4@email.pt");
        registarColaboradoresEquipa("123","email5@email.pt");

        registarColaboradoresEquipa("540","email8@email.pt");
        registarColaboradoresEquipa("540","email3@email.pt");
        registarColaboradoresEquipa("540","email6@email.pt");
        registarColaboradoresEquipa("123","email7@email.pt");

        return true;
    }

    private void registerColaborador(String email, String nomeComum, String nomeCompleto, String localResidencia, String telemovel, String dataNascimento, String funcao){
        try{
            especificarColaboradorController.novoColaborador(email, nomeComum, nomeCompleto, localResidencia, telemovel, dataNascimento, funcao);
            especificarColaboradorController.registarColaborador();
            LOGGER.info(email);
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", email);
            LOGGER.trace("Assuming existing record", e);
        }
    }

    private void registerEquipa(String identificadorUnico, String acronimoUnico, String descricao, String codigoTipoEquipa){
        try{
            equipaController.novaEquipa(identificadorUnico,acronimoUnico,descricao);
            equipaController.getTiposEquipa();
            equipaController.adicionarTipoEquipa(codigoTipoEquipa);
            equipaController.registarEquipa();
            LOGGER.info(identificadorUnico);
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", identificadorUnico);
            LOGGER.trace("Assuming existing record", e);
        }

    }

    private void registerTipoEquipa(String codigoUnicoInterno, String descricao, String cor){
        try{
            tipoEquipaController.novoTipoEquipa(codigoUnicoInterno,descricao,cor);
            tipoEquipaController.registarTipoEquipa();
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", codigoUnicoInterno);
            LOGGER.trace("Assuming existing record", e);
        }
    }

//    private void registarColaboradorResponsavelEquipa(String identificadorUnico, String emailColaborador1){
//        associarColaboradorEquipaController.getColaboradores();
//        associarColaboradorEquipaController.getEquipas();
//        associarColaboradorEquipaController.adicionarColaboradorEquipa(emailColaborador1,identificadorUnico);
//        associarColaboradorEquipaController.getColaboradoresEquipa();
//        associarColaboradorEquipaController.adicionarColaboradorResponsavel(emailColaborador1);
//        associarColaboradorEquipaController.registarColaboradoresEquipa();
//
//    }

    private void registarColaboradoresEquipa(String identificadorUnico, String emailColaborador1){
        associarColaboradorEquipaController.getColaboradores();
        associarColaboradorEquipaController.getEquipas();
        associarColaboradorEquipaController.adicionarColaboradorEquipa(emailColaborador1,identificadorUnico);

        associarColaboradorEquipaController.registarColaboradoresEquipa();

    }

}
