package com.br.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.ufc.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{
	Role findByNomeRole(String nomeRole);
}
