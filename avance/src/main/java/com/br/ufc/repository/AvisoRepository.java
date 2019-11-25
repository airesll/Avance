package com.br.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.ufc.model.Aviso;

@Repository
public interface AvisoRepository extends JpaRepository<Aviso, Long> {
	Aviso findByIdAviso(Long idAviso);
}
