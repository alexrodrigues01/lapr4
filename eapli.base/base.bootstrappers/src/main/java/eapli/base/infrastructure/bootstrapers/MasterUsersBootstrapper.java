/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import java.util.HashSet;
import java.util.Set;

import eapli.base.colaboradormanagement.application.EspecificarColaboradorController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerAdmin("admin", TestDataConstants.PASSWORD1, "Jane", "Doe Admin",
                "jane.doe@email.local");
        registerRH("admin2",TestDataConstants.PASSWORD1,"Janee","Doe RH","jane.doe45@email.local");
        registerGestorHelp("gestor",TestDataConstants.PASSWORD1,"Harry","Xanax","harry@gmail.com");
        return true;
    }

    /**
     *
     */
    private void registerRH(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.RESPONSAVEL_RH);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerAdmin(final String username, final String password, final String firstName,
                               final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerGestorHelp(final String username, final String password, final String firstName,
                               final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.GESTOR_HELPDESK);
        EspecificarColaboradorController especificarColaboradorController = new EspecificarColaboradorController();
        especificarColaboradorController.novoColaborador(email,firstName,firstName+" "+lastName,"Armis","911111111","2001-09-11","GestorHelpDesk");
        especificarColaboradorController.registarGestor();
    }

}
