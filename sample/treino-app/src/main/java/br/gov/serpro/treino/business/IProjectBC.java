package br.gov.serpro.treino.business;

import java.util.Date;
import java.util.List;

import br.gov.framework.demoiselle.core.layer.IBusinessController;
import br.gov.serpro.treino.bean.Obra;

public interface IProjectBC extends IBusinessController {

	public Obra insert(Obra projeto);

	public List<Obra> list();

	public void update(Obra project);

	public void delete(Obra project);

	public Obra findProject(Obra project);

	public Obra load(Long id);

	public void enviarProposta(Obra obra, Double novoValor, Date novoPrazo, String username);

	public void clean();


	
}
