package br.gov.serpro.treino.persistence.dao.implementation;

import java.util.Date;
import java.util.List;

import br.gov.serpro.treino.bean.Obra;
import br.gov.serpro.treino.persistence.dao.IProjectDAO;

public class ProjectDAO extends TestGridDAO<Obra> implements IProjectDAO {

	private static final long serialVersionUID = 1L;

	public Obra save(Obra proj) {
		proj.setAtualizacao(new Date());
		if (proj.getId() != null) {
			this.update(proj);
		} else {
			this.insert(proj);
		}
		return proj;
	}

	public Obra findProjetoByName(String nome) {
		return (Obra) findObjectByField("nome", nome, Obra.class);
	}


	
	public List<Obra> list() {
		return super.list("nome", Obra.class);
	}

	public List<Obra> listRemoved() {
		return super.listRemoved("nome", Obra.class);
	}



	public Obra load(Obra Obra) {
		return (Obra) super.load(Obra, Obra.class);
	}


}
