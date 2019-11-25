package com.br.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.ufc.model.Questao;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long> {

}
