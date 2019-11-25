package com.br.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ufc.model.Questao;
import com.br.ufc.repository.QuestaoRepository;

@Service
public class QuestaoService {
	@Autowired
	private QuestaoRepository questaoRepository;
	
	public void cadastrarQuestao(Questao questao) {
		
		questaoRepository.save(questao);
		
	}

	public  List <Questao> listarQuestoes() {
		
		return questaoRepository.findAll();
	}

	public void excluirQuestao(Long id) {
		questaoRepository.deleteById(id);	
	}
}
