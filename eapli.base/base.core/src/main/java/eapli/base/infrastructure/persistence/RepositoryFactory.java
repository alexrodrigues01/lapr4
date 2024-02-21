/**
 *
 */
package eapli.base.infrastructure.persistence;

import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.catalogomanagement.repositories.ObjetivoRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;

import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.equipaManagement.repositories.EquipaRepository;
import eapli.base.equipaManagement.repositories.TipoEquipaRepository;
import eapli.base.fluxotarefaresolucao.repositories.TarefaAprovResRepository;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.base.nivelcriticidademanagement.repositories.NivelCriticidadeRepository;
import eapli.base.servicomanagement.domain.Pedido;
import eapli.base.servicomanagement.repositories.*;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

	/**
	 * factory method to create a transactional context to use in the repositories
	 *
	 * @return
	 */
	TransactionalContext newTransactionalContext();

	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	UserRepository users(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	UserRepository users();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ColaboradorRepository colaboradores();
	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	ColaboradorRepository colaboradores(TransactionalContext autoTx);



	CatalogoRepository catalogos();


	CatalogoRepository catalogos(TransactionalContext ctx);



	ObjetivoRepository objetivos();


	ObjetivoRepository objetivos(TransactionalContext ctx);
	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	ClientUserRepository clientUsers(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ClientUserRepository clientUsers();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	SignupRequestRepository signupRequests(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	SignupRequestRepository signupRequests();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	AtributoRepository atributos();
	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	AtributoRepository atributos(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	FormularioRepository formularios();
	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	FormularioRepository formularios(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	KeywordRepository keywords();
	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	KeywordRepository keywords(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ServicoRepository servicos();
	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	ServicoRepository servicos(TransactionalContext autoTx);

	EquipaRepository equipas();

	EquipaRepository equipas(TransactionalContext autoTx);

	TipoEquipaRepository tiposEquipa();

	TipoEquipaRepository tiposEquipa(TransactionalContext autoTx);

	NivelCriticidadeRepository nivelCriticidade();

	NivelCriticidadeRepository nivelCriticidade(TransactionalContext autoTx);

	PedidoRepository pedido();

	PedidoRepository pedido(TransactionalContext autoTx);

	FluxoTarefaRepository fluxoTarefa();

	FluxoTarefaRepository fluxoTarefa(TransactionalContext autoTx);

	TarefaAprovResRepository tarefaAprovRes();

	TarefaAprovResRepository tarefaAprovRes(TransactionalContext autoTx);

	TarefaExecResRepository tarefaExecRes();

	TarefaExecResRepository tarefaExecRes(TransactionalContext autoTx);
}
