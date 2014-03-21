package br.gov.serpro.treino.view.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import br.gov.serpro.treino.bean.Obra;
import br.gov.serpro.treino.business.IProjectBC;
import br.gov.serpro.treino.business.implementation.ProjectBC;
import br.gov.serpro.treino.constant.Navigation;
import br.gov.serpro.treino.exception.InfoMessage;

@ManagedBean(name = "obraMB")
@SessionScoped
public class ObraMB extends TestGridMB {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(ObraMB.class);

	private IProjectBC projectBC;
	protected Obra currentProject;

	private String projectSelectedId;

	public List<Obra> obras;
	private List<SelectItem> projectItens = new ArrayList<SelectItem>();
	private Obra obra;

	private Double novoValor;
	private Date novoPrazo;
	
	public ObraMB(){
		projectBC = new ProjectBC();
	}

	@PostConstruct
	public void init() {
		obra = new Obra();
		obras = new ArrayList<Obra>();
		projectItens = new ArrayList<SelectItem>();
		modeInsert = false;
		projectSelectedId = "0";
	}

	public void loadProjects() {
		if (obras.isEmpty()) {
			load();
		}
	}

	private void load() {
		obras = projectBC.list();
		projectItens.clear();
		for (Obra project : getObras()) {
			projectItens.add(new SelectItem(project.getId() + "", project.getNome()));
		}
	}

	@Override
	public void setModeInsert(Boolean modeInsert) {
		super.setModeInsert(modeInsert);
		this.obra = new Obra();
	}
	
	public void cancel(){
		super.setModeInsert(false);
	}

	/**
	 * Retorna todos os projetos da base
	 * 
	 * @return
	 */
	public String list() {
		log.debug("list");
		load();
		this.obra = new Obra();
		return Navigation.OBRA;
	}

	/**
	 * Insere um novo projeto
	 * 
	 * @param actionEvent
	 * @return
	 */
	public void insert(ActionEvent actionEvent) {
		try {
			log.debug("insert");
			obra = projectBC.insert(obra);
			String[] param = { obra.getNome() };
			load();
			obra = new Obra();
			FacesUtil.addMessage(InfoMessage.SAVE_OK, param);
		} catch (Throwable e) {
			FacesUtil.handleException(e);
		}
	}

	public void update(RowEditEvent event) {
		try {
			log.debug("update - RowEditEvent");
			obra = (Obra) event.getObject();
			update();
		} catch (Throwable e) {
			FacesUtil.handleException(e);
		}

	}

	/**
	 * Atualiza um projeto da base
	 * 
	 * @param event
	 */
	public void update() {
		try {
			log.debug("update");
			projectBC.update(obra);
			String[] param = { obra.getNome() };
			obra = new Obra();
			load();
			FacesUtil.addMessage(InfoMessage.SAVE_OK, param);
		} catch (Throwable e) {
			FacesUtil.handleException(e);
		}

	}
	
	public void clean(ActionEvent event){
		try {
			log.debug("clean");
			projectBC.clean();			
			obra = new Obra();
			load();
			FacesUtil.addMessage(InfoMessage.CLEAN_OK);
		} catch (Throwable e) {
			FacesUtil.handleException(e);
		}
	}

	/**
	 * Remove um projeto da base
	 */
	public void delete(ActionEvent event) {
		try {
			log.debug("delete");
			String[] param = { obra.getNome() };
			projectBC.delete(obra);
			load();
			obra = new Obra();
			FacesUtil.addMessage(InfoMessage.DELETE_OK, param);
		} catch (Throwable e) {
			FacesUtil.handleException(e);
		}
	}
	
	
	public void enviarProposta(ActionEvent event){
		try {
			HttpSession session  = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			String username = (String) session.getAttribute("username");			
			log.debug("enviarProposta");			
			projectBC.enviarProposta(obra, novoValor, novoPrazo, username);
			load();
			obra = new Obra();
			FacesUtil.addMessage(InfoMessage.PROPOSTA_ACEITA);
		} catch (Throwable e) {
			FacesUtil.handleException(e);
		}
		
	}

	public List<SelectItem> getProjectSelectItens() {
		return projectItens;
	}

	/**
	 * Faz upload do jmx
	 * 
	 * @param event
	 */

	// GETS e SET
	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		novoPrazo = obra.getPrazo();
		novoValor = obra.getValor();
		this.obra = projectBC.findProject(obra);
	}

	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> projects) {
		this.obras = projects;
	}

	public Obra getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(Obra currentProject) {
		this.currentProject = currentProject;
		if (currentProject == null) {
			setProjectSelectedId(0l + "");
		} else {
			setProjectSelectedId(currentProject.getId() + "");
		}
	}

	public String getProjectSelectedId() {
		return projectSelectedId;
	}

	public void setProjectSelectedId(String projectSelectedId) {
		this.projectSelectedId = projectSelectedId;
	}

	public Double getNovoValor() {
		return novoValor;
	}

	public void setNovoValor(Double novoValor) {
		this.novoValor = novoValor;
	}

	public Date getNovoPrazo() {
		return novoPrazo;
	}

	public void setNovoPrazo(Date novoPrazo) {
		this.novoPrazo = novoPrazo;
	}

}
