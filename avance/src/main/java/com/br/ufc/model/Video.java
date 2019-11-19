package com.br.ufc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVideo;
	//os videos ficaram em disco
	//no banco de daos ficara salvo somente os caminhos
	private String caminhoDoVideo;
	
	//um video pode estar em varios treinamentos
	@ManyToMany
	@JoinTable(name="videos_treinamentos", 
			joinColumns = @JoinColumn(
			name = "video_id",referencedColumnName =  "idVideo"),
			inverseJoinColumns = @JoinColumn(
			name ="treinamento_id",referencedColumnName = "idTreinamento"))
	private List<Treinamento> treinamentos;
	
	//GETS AND SETS
	public Long getId() {
		return idVideo;
	}
	public void setId(Long idVideo) {
		this.idVideo = idVideo;
	}
	public String getCaminhoDoVideo() {
		return caminhoDoVideo;
	}
	public void setCaminhoDoVideo(String caminhoDoVideo) {
		this.caminhoDoVideo = caminhoDoVideo;
	}
	public List<Treinamento> getTreinamentos() {
		return treinamentos;
	}
	public void setTreinamentos(List<Treinamento> treinamentos) {
		this.treinamentos = treinamentos;
	}
}