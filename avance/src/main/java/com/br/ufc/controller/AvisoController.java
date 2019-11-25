package com.br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.ufc.model.Aviso;
import com.br.ufc.service.AvisoService;

@Controller
@RequestMapping("/aviso")
public class AvisoController {
	
	@Autowired
	private AvisoService avisoService;
	
	@RequestMapping("")
	public String form() {
		return "formAviso";
	}
	
	@RequestMapping("/salvar")
	public String cadastrarAviso(Aviso aviso) {
		
		avisoService.cadastrarAviso(aviso);
//		System.out.println("Nome:" + usuario.getNome());
		return "ok";
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarAvisos(Aviso Aviso) {
		
		List<Aviso> avisos = avisoService.listarAvisos();
		ModelAndView mv = new ModelAndView("listaAvisos");
		mv.addObject("listaDeAvisos", avisos);
//		System.out.println("Nome:" + usuario.getNome());
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirAviso(@PathVariable Long id) {
		avisoService.excluirAviso(id);
		ModelAndView mv = new ModelAndView ("redirect:../listar");
		return mv;
		
	}

}