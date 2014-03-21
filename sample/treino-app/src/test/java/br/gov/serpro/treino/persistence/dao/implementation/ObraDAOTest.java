package br.gov.serpro.treino.persistence.dao.implementation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.gov.framework.demoiselle.core.layer.IFacade;
import br.gov.framework.demoiselle.core.transaction.ITransactionContext;
import br.gov.framework.demoiselle.web.transaction.WebTransactionContext;
import br.gov.serpro.treino.bean.Obra;
import br.gov.serpro.treino.persistence.dao.IProjectDAO;

public class ObraDAOTest implements IFacade {

	private static final long serialVersionUID = 1L;

	private IProjectDAO projectDAO = new ProjectDAO();

	private ITransactionContext transaction;

	@Before
	public void before() {
		transaction = WebTransactionContext.getInstance();
		transaction.init();
	}

	@After
	public void after() {
		transaction = WebTransactionContext.getInstance();
		transaction.end();
	}

	@Test
	public void testSave() {
		Obra p = new Obra();
		p.setNome("Mineirao");
		p.setValor(100000.00);
		p.setPrazo(new Date());
		p.setVencedor("usuario001");
		p = projectDAO.save(p);
		p = projectDAO.load(p);
		assertNotNull(p);
		assertTrue(p.getId() > 0);
	}

}
