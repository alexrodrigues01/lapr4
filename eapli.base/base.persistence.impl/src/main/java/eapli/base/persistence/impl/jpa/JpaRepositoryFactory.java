package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.catalogomanagement.repositories.ObjetivoRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.equipaManagement.repositories.EquipaRepository;
import eapli.base.equipaManagement.repositories.TipoEquipaRepository;
import eapli.base.fluxotarefaresolucao.repositories.TarefaAprovResRepository;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.nivelcriticidademanagement.repositories.NivelCriticidadeRepository;
import eapli.base.servicomanagement.repositories.*;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

	@Override
	public UserRepository users(final TransactionalContext autoTx) {
		return new JpaAutoTxUserRepository(autoTx);
	}

	@Override
	public UserRepository users() {
		return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}

	@Override
	public JpaColaboradorRepository colaboradores() {
		return new JpaColaboradorRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public JpaColaboradorRepository colaboradores(TransactionalContext autoTx) {
		return new JpaColaboradorRepository(autoTx);
	}

	@Override
	public CatalogoRepository catalogos() {
		return new JpaCatalogoRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public CatalogoRepository catalogos(TransactionalContext ctx) {
		return new JpaCatalogoRepository(ctx);
	}

	@Override
	public ObjetivoRepository objetivos() {
		return new JpaObjetivoRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ObjetivoRepository objetivos(TransactionalContext ctx) {
		return new JpaObjetivoRepository(ctx);
	}

	@Override
	public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
		return new JpaClientUserRepository(autoTx);
	}

	@Override
	public JpaClientUserRepository clientUsers() {
		return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
		return new JpaSignupRequestRepository(autoTx);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public AtributoRepository atributos() {
		return new JpaAtributoRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public AtributoRepository atributos(TransactionalContext autoTx) {
		return new JpaAtributoRepository(autoTx);
	}

	@Override
	public FormularioRepository formularios() {
		return new JpaFormularioRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public FormularioRepository formularios(TransactionalContext autoTx) {
		return new JpaFormularioRepository(autoTx);
	}

	@Override
	public KeywordRepository keywords() {
		return new JpaKeywordRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public KeywordRepository keywords(TransactionalContext autoTx) {
		return new JpaKeywordRepository(autoTx);
	}

	@Override
	public ServicoRepository servicos() {
		return new JpaServicoRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ServicoRepository servicos(TransactionalContext autoTx) {
		return new JpaServicoRepository(autoTx);
	}

	@Override
	public EquipaRepository equipas() {
		return new JpaEquipaRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public EquipaRepository equipas(TransactionalContext autoTx) {
		return new JpaEquipaRepository(autoTx);
	}

	@Override
	public TipoEquipaRepository tiposEquipa() {
		return new JpaTipoEquipaRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TipoEquipaRepository tiposEquipa(TransactionalContext autoTx) {
		return new JpaTipoEquipaRepository(autoTx);
	}



	@Override
	public NivelCriticidadeRepository nivelCriticidade() {
		return new JpaNivelCriticidadeRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public NivelCriticidadeRepository nivelCriticidade(TransactionalContext autoTx) {
		return new JpaNivelCriticidadeRepository(autoTx);
	}

	@Override
	public PedidoRepository pedido() {
		return new JpaPedidoRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public PedidoRepository pedido(TransactionalContext autoTx) {
		return new JpaPedidoRepository(autoTx);
	}

	@Override
	public FluxoTarefaRepository fluxoTarefa(){
		return new JpaFluxoTarefaRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public FluxoTarefaRepository fluxoTarefa(TransactionalContext autoTx){
		return new JpaFluxoTarefaRepository(autoTx);
	}

	@Override
	public TarefaAprovResRepository tarefaAprovRes() {
		return new JpaTarefaAprovResRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TarefaAprovResRepository tarefaAprovRes(TransactionalContext autoTx) {
		return new JpaTarefaAprovResRepository(autoTx);
	}

	@Override
	public TarefaExecResRepository tarefaExecRes() {
		return new JpaTarefaExecResRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TarefaExecResRepository tarefaExecRes(TransactionalContext autoTx) {
		return new JpaTarefaExecResRepository(autoTx);
	}


	@Override
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}


}
