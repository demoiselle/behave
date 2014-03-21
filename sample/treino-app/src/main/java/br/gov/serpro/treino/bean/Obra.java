package br.gov.serpro.treino.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.framework.demoiselle.core.bean.IPojo;

@Entity
@Table(name = "tb_obra")
public class Obra implements IPojo {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome", length = 150, nullable = false)
	private String nome;

	@Column(name = "prazo", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date prazo;
	
	@Column(name = "atualizacao")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date atualizacao;

	@Column(name = "valor")
	private Double valor;

	@Column(name = "vencedor", length = 30)
	private String vencedor;

	public Obra() {
		this.valor = 0.01;
	}

	public Obra(String nome, double valor, String date) throws ParseException {
		this.nome = nome;
		this.valor = valor;
		this.vencedor = "";
		this.prazo = (new SimpleDateFormat("dd/MM/yyyy")).parse(date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getPrazo() {
		return prazo;
	}

	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getVencedor() {
		return vencedor;
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}

	public Date getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(Date atualizacao) {
		this.atualizacao = atualizacao;
	}

}
