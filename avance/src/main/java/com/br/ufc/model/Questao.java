package com.br.ufc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String pergunta;
	private String resposta;
	
	@ManyToMany(mappedBy = "questoes")
	private List<Teste> testes;
	
	//GETS AND SETS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public List<Teste> getTestes() {
		return testes;
	}
	public void setTestes(List<Teste> testes) {
		this.testes = testes;
	}
}