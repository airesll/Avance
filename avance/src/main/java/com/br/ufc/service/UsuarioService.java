package com.br.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ufc.model.Usuario;
import com.br.ufc.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void cadastrarFuncionario(Usuario usuario) {
		
		usuarioRepository.save(usuario);
		
	}

	public  List <Usuario> listarFuncionarios() {
		
		return usuarioRepository.findAll();
	}

	public void excluir(Long id) {
		usuarioRepository.deleteById(id);	
	}
}
