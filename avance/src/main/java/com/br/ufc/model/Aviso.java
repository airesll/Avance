package com.br.ufc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aviso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAviso;
	private String descricao;
	private Date dataAviso;
	
	@ManyToOne
	@JoinColumn(name="idTreinamento")
	private Treinamento treinamento;
	
	//GETS AND SETS
	public Long getId() {
		return idAviso;
	}
	public void setId(Long idAviso) {
		this.idAviso = idAviso;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataAviso() {
		return dataAviso;
	}
	public void setDataAviso(Date dataAviso) {
		this.dataAviso = dataAviso;
	}
	public Treinamento getTreinamento() {
		return treinamento;
	}
	public void setTreinamento(Treinamento treinamento) {
		this.treinamento = treinamento;
	}
}