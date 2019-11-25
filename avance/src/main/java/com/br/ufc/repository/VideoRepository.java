package com.br.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.ufc.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{

}
