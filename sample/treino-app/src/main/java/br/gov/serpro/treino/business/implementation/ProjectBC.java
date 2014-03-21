package br.gov.serpro.treino.business.implementation;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.gov.serpro.treino.bean.Obra;
import br.gov.serpro.treino.business.IProjectBC;
import br.gov.serpro.treino.exception.ErrorMessage;
import br.gov.serpro.treino.exception.TestGridException;
import br.gov.serpro.treino.persistence.dao.IProjectDAO;
import br.gov.serpro.treino.persistence.dao.implementation.ProjectDAO;

public class ProjectBC implements IProjectBC {

	private static final long serialVersionUID = 1L;

	private IProjectDAO projetoDAO = new ProjectDAO();


	/**
	 * Insere projeto verificando se ha alguma duplicidade
	 */
	public Obra insert(Obra project) {
		return projetoDAO.save(project);
	}

	public void update(Obra project) {
		project.setAtualizacao(new Date());
		projetoDAO.merge(project);
	}

	public List<Obra> list() {
		return projetoDAO.list();
	}

	public void delete(Obra project) {
		project = projetoDAO.load(project);
		projetoDAO.remove(project);
	}

	public Obra findProject(Obra project) {
		return projetoDAO.load(project);
	}

	public Obra load(Long id) {
		Obra p = new Obra();
		p.setId(id);
		return projetoDAO.load(p);
	}

	public synchronized void enviarProposta(Obra _obra, Double novoValor, Date novoPrazo, String username) {
		Obra obra = projetoDAO.load(_obra);
		if (novoValor.compareTo(obra.getValor()) >= 0){
			DecimalFormat df = new DecimalFormat("R$ #,##0.00");
			String[] param = {"Valor", df.format(novoValor)};
			throw new TestGridException(ErrorMessage.PROPOSTA_RECUSADA, param);
		}
		if (novoPrazo.compareTo(obra.getPrazo()) >= 0){
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String[] param = {"Prazo", format.format(novoPrazo)};
			throw new TestGridException(ErrorMessage.PROPOSTA_RECUSADA, param);			
		}
		obra.setValor(novoValor);
		obra.setPrazo(novoPrazo);
		obra.setVencedor(username);
		update(obra);
	}

	public void clean() {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 6);
		calendar.set(Calendar.DAY_OF_MONTH, 30);
		for(Obra obra : projetoDAO.list()){
			obra.setVencedor("");
			obra.setPrazo(calendar.getTime());
			obra.setValor(100000.00);
			update(obra);
		}		
	}

	

}
