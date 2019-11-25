package com.br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.ufc.model.Questao;
import com.br.ufc.service.QuestaoService;

@Controller
@RequestMapping("/questao")
public class QuestaoController {
	
	@Autowired
	private QuestaoService questaoService;
	
	@RequestMapping("")
	public String form() {
		return "formQuestao";
	}
	
	@RequestMapping("/salvar")
	public String cadastrarQuestao(Questao questao) {
		
		questaoService.cadastrarQuestao(questao);
//		System.out.println("Nome:" + usuario.getNome());
		return "ok";
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarQuestoes(Questao questao) {
		
		List<Questao> questoes = questaoService.listarQuestoes();
		ModelAndView mv = new ModelAndView("listaQuestoes");
		mv.addObject("listaDeQuestoes", questoes);
//		System.out.println("Nome:" + usuario.getNome());
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirQuestao(@PathVariable Long id) {
		questaoService.excluirQuestao(id);
		ModelAndView mv = new ModelAndView ("redirect:../listar");
		return mv;
		
	}
}