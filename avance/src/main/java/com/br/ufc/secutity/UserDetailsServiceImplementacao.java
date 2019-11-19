package com.br.ufc.secutity;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.br.ufc.model.Usuario;
import com.br.ufc.repository.UsuarioRepository;


@Repository
@Transactional
public class UserDetailsServiceImplementacao implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(login);
		
		//se nao existir usuario
		if(usuario == null) {
			throw new UsernameNotFoundException("usuario nao encontrado");
		}
		return new User(usuario.getLogin(),usuario.getSenha(),true,true,true,true,usuario.getAuthorities()); 
	}
}