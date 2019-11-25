package com.br.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ufc.model.Aviso;
import com.br.ufc.repository.AvisoRepository;

@Service
public class AvisoService {
	@Autowired
	private AvisoRepository avisoRepository;
	
	public void cadastrarAviso(Aviso aviso) {
		
		avisoRepository.save(aviso);
		
	}

	public  List <Aviso> listarAvisos() {
		
		return avisoRepository.findAll();
	}

	public void excluirAviso(Long id) {
		avisoRepository.deleteById(id);	
	}
}
