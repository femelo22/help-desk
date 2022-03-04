package com.lfmelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfmelo.domain.Tecnico;
import com.lfmelo.exceptions.NotFoundException;
import com.lfmelo.repositories.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Objeto não encontrado de id " + id));
	}
	
	public List<Tecnico> findAll() {
		return this.repository.findAll();
	}

	public Tecnico create(Tecnico tecnico) {
		return this.repository.save(tecnico);
	}
	
	
}
