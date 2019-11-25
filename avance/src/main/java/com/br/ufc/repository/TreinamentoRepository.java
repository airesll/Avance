package com.br.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.ufc.model.Treinamento;

@Repository
public interface TreinamentoRepository extends JpaRepository<Treinamento, Long> {

}
