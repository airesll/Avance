package com.br.ufc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Treinamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTreinamento;
	private Date dataInicial;
	private Date dataFinal;
	
	@ManyToMany(mappedBy = "treinamentos")
	private List<Video> caminhoDosVideos;
	
	@ManyToMany(mappedBy = "treinamentos")
	private List<Usuario> usuarios;
	
	@OneToMany(mappedBy = "treinamento", targetEntity = Aviso.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aviso> avisos;
	
	@OneToOne(mappedBy = "treinamento", cascade = CascadeType.ALL)
	private Teste teste;
	
	//GETS AND SETS
	public Long getId() {
		return idTreinamento;
	}
	public void setId(Long idTreinamento) {
		this.idTreinamento = idTreinamento;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public List<Video> getCaminhoDosVideos() {
		return caminhoDosVideos;
	}
	public void setCaminhoDosVideos(List<Video> caminhoDosVideos) {
		this.caminhoDosVideos = caminhoDosVideos;
	}
	public Teste getTeste() {
		return teste;
	}
	public void setTeste(Teste teste) {
		this.teste = teste;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Aviso> getAvisos() {
		return avisos;
	}
	public void setAvisos(List<Aviso> avisos) {
		this.avisos = avisos;
	}
}