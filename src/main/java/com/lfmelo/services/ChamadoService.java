package com.lfmelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfmelo.domain.Chamado;
import com.lfmelo.exceptions.NotFoundException;
import com.lfmelo.repositories.ChamadoRepository;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;
	
	public Chamado findById(Integer id) {
		return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Objeto não encontrado id " + id));
	}
	
	public List<Chamado> findAll() {
		return this.repository.findAll();
	}
	
	
}
