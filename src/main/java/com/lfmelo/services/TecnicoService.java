package com.lfmelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfmelo.domain.Tecnico;
import com.lfmelo.repositories.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		return this.repository.findById(id).orElseThrow();
	}
}
