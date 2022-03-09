package com.lfmelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.lfmelo.domain.Pessoa;
import com.lfmelo.exceptions.NotFoundException;
import com.lfmelo.repositories.PessoaRepository;
import com.lfmelo.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws NotFoundException {
		Pessoa user = pessoaRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Objeto não encontrado, email: " + email));
		return new UserSS(user.getId(), user.getEmail(), user.getSenha(), user.getPerfis());
	}
	
	

}
