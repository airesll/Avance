package com.br.ufc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.br.ufc.secutity.UserDetailsServiceImplementacao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsServiceImplementacao userDetailsServiceImplementacao;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		
		//todos podem acessar
		.antMatchers("/novoCadastro").permitAll()
		.antMatchers("/cliente/salvar").permitAll()
		.antMatchers("/").permitAll()
		
		.antMatchers("/gerente/cadastrarNovoPrato").hasAuthority("ROLE_GERENTE")
		.antMatchers("/gerente/salvarPrato").hasAnyAuthority("ROLE_GERENTE")
		.antMatchers("/gerente/listaDePratos").hasAnyAuthority("ROLE_GERENTE")
		.antMatchers("/gerente/excluirPrato").hasAnyAuthority("ROLE_GERENTE")
		.antMatchers("/atualizarPrato/").hasAnyAuthority("ROLE_GERENTE")
		//qualquer outra requisiçao tem que ser autenticada
		.anyRequest().authenticated()
		
		.and()
		.formLogin().permitAll()
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImplementacao)
		.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/img/**","/js/**","/images/**","/common/**","/fonts/**","/plugin-frameworks/**");
	}
}