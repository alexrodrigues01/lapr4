package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.catalogomanagement.repositories.ObjetivoRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.equipaManagement.repositories.EquipaRepository;
import eapli.base.equipaManagement.repositories.TipoEquipaRepository;
import eapli.base.fluxotarefaresolucao.repositories.TarefaAprovResRepository;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.nivelcriticidademanagement.repositories.NivelCriticidadeRepository;
import eapli.base.servicomanagement.repositories.*;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

	static {
		// only needed because of the in memory persistence
		new BaseBootstrapper().execute();
	}

	@Override
	public UserRepository users(final TransactionalContext tx) {
		return new InMemoryUserRepository();
	}

	@Override
	public UserRepository users() {
		return users(null);
	}

	@Override
	public ColaboradorRepository colaboradores() {
		return colaboradores(null);
	}

	@Override
	public ColaboradorRepository colaboradores(TransactionalContext autoTx) {
		return new InMemoryColaboradorRepository();
	}

	@Override
	public CatalogoRepository catalogos() {
		return catalogos(null);
	}

	@Override
	public CatalogoRepository catalogos(TransactionalContext ctx) {
		return new InMemoryCatalogoRepository();
	}

	@Override
	public ObjetivoRepository objetivos() {
		return objetivos(null);
	}

	@Override
	public ObjetivoRepository objetivos(TransactionalContext ctx) {
		return new InMemoryObjetivoRepository();
	}


	@Override
	public ClientUserRepository clientUsers(final TransactionalContext tx) {
		return new InMemoryClientUserRepository();
	}

	@Override
	public ClientUserRepository clientUsers() {
		return clientUsers(null);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return signupRequests(null);
	}

	@Override
	public AtributoRepository atributos() {
		return atributos(null);
	}

	@Override
	public AtributoRepository atributos(TransactionalContext autoTx) {
		return new InMemoryAtributoRepository();
	}

	@Override
	public FormularioRepository formularios() {
		return formularios(null);
	}

	@Override
	public FormularioRepository formularios(TransactionalContext autoTx) {
		return new InMemoryFormularioRepository();
	}

	@Override
	public KeywordRepository keywords() {
		return keywords(null);
	}

	@Override
	public KeywordRepository keywords(TransactionalContext autoTx) {
		return new InMemoryKeywordRepository();
	}

	@Override
	public ServicoRepository servicos() {
		return servicos(null);
	}

	@Override
	public ServicoRepository servicos(TransactionalContext autoTx) {
		return new InMemoryServicoRepository();
	}

	@Override
	public EquipaRepository equipas() {
		return equipas(null);
	}

	@Override
	public EquipaRepository equipas(TransactionalContext autoTx) {
		return new InMemoryEquipaRepository();
	}

	@Override
	public TipoEquipaRepository tiposEquipa() {
		return tiposEquipa(null);
	}

	@Override
	public TipoEquipaRepository tiposEquipa(TransactionalContext autoTx) {
		return new InMemoryTipoEquipaRepository();
	}

	@Override
	public NivelCriticidadeRepository nivelCriticidade() {
		return null;
	}

	@Override
	public NivelCriticidadeRepository nivelCriticidade(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public PedidoRepository pedido() {
		return pedido(null);
	}

	@Override
	public PedidoRepository pedido(TransactionalContext autoTx) {
		return new InMemoryPedidoRepository();
	}

	@Override
	public FluxoTarefaRepository fluxoTarefa() {
		return fluxoTarefa(null);
	}

	@Override
	public FluxoTarefaRepository fluxoTarefa(TransactionalContext autoTx) {
		return new InMemoryFluxoTarefaRepository();
	}

	@Override
	public TarefaAprovResRepository tarefaAprovRes() {
		return null;
	}

	@Override
	public TarefaAprovResRepository tarefaAprovRes(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public TarefaExecResRepository tarefaExecRes() {
		return null;
	}

	@Override
	public TarefaExecResRepository tarefaExecRes(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext tx) {
		return new InMemorySignupRequestRepository();
	}


	@Override
	public TransactionalContext newTransactionalContext() {
		// in memory does not support transactions...
		return null;
	}

}
