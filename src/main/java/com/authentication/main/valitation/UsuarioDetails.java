package com.authentication.main.valitation;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.authentication.main.repositories.IUsuarioRepository;

/*
 * Nombre de la clase: UsuarioDetails
 * Fecha: 3/11/2019
 * Versión: 1.0
 * CopyRight: 
 * Autor: Téc. Balmore Pérez
 */

@Component
public class UsuarioDetails implements UserDetailsService{
	
	 private IUsuarioRepository usuarioRepository;
	 
	 public UsuarioDetails(IUsuarioRepository usuarioRepository)
	 {
		 this.usuarioRepository = usuarioRepository;
	 }
	 
	 @Override
	 public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 return usuarioRepository.findByEmail(email)
				 .map(user -> new User(user.getEmail(),
						 user.getPassword(), user.isEnabled(),
						 user.isEnabled(), user.isEnabled(), user.isEnabled(),
						 AuthorityUtils.createAuthorityList("USER")
						 ))
				 .orElseThrow(() -> new UsernameNotFoundException("can't find"));
	 }
}
