package com.br.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.ufc.model.Teste;

@Repository
public interface TesteRepository extends JpaRepository<Teste, Long> {

}
