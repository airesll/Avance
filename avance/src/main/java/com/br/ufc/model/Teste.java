package com.br.ufc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Teste {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@MapsId
	private Treinamento treinamento;
	
	@ManyToMany
    @JoinTable(name="questoes_teste", joinColumns=
		    {@JoinColumn(name="teste_id")}, inverseJoinColumns=
		    {@JoinColumn(name="questao_id")})
	private List<Questao> questoes;
	
	//GETS AND SETS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Treinamento getTreinamento() {
		return treinamento;
	}
	public void setIdTreinamento(Treinamento treinamento) {
		this.treinamento =treinamento;
	}
	public List<Questao> getQuestoes() {
		return questoes;
	}
	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}	
}