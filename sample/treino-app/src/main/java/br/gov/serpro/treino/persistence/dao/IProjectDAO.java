package br.gov.serpro.treino.persistence.dao;

import java.util.List;

import br.gov.framework.demoiselle.core.layer.IDAO;
import br.gov.serpro.treino.bean.Obra;

public interface IProjectDAO extends IDAO<Obra> {

	public Obra save(Obra project);	
	
	public Obra findProjetoByName(String name);
	
	public List<Obra> list();

	public void merge(Obra project);

	public Obra load(Obra project);

}
