package com.br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.ufc.model.Usuario;
import com.br.ufc.service.UsuarioService;

@Controller
@RequestMapping("/cadastro")
public class AnalistaController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("")
	public String form() {
		return "form";
	}
	
	@RequestMapping("/salvar")
	public String cadastrarFuncionario(Usuario usuario) {
		
		usuarioService.cadastrarFuncionario(usuario);
//		System.out.println("Nome:" + usuario.getNome());
		return "ok";
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarFuncionarios(Usuario usuario) {
		
		List<Usuario> usuarios = usuarioService.listarFuncionarios();
		ModelAndView mv = new ModelAndView("listaFuncionarios");
		mv.addObject("listaDeFuncionarios", usuarios);
//		System.out.println("Nome:" + usuario.getNome());
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable Long id) {
		usuarioService.excluir(id);
		ModelAndView mv = new ModelAndView ("redirect:../listar");
		return mv;
		
	}
}
