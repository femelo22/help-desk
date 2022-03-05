package com.lfmelo.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfmelo.domain.Cliente;
import com.lfmelo.domain.Tecnico;
import com.lfmelo.dtos.ClienteDTO;
import com.lfmelo.dtos.TecnicoDTO;
import com.lfmelo.exceptions.DataIntegrityViolationException;
import com.lfmelo.exceptions.NotFoundException;
import com.lfmelo.repositories.ClienteRepository;
import com.lfmelo.repositories.TecnicoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente findById(Integer id) {
		return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Objeto não encontrado de id " + id));
	}
	
	public List<Cliente> findAll() {
		return this.repository.findAll();
	}

	public Cliente create(Cliente cliente) {
		return this.repository.save(cliente);
	}

	public void update(ClienteDTO dto, Integer id) {
		Cliente cliente = this.findById(id); 
		BeanUtils.copyProperties(dto, cliente);
		this.repository.save(cliente);
	}

	public void delete(Integer id) {
		Cliente cliente = this.findById(id);
		this.repository.delete(cliente);
	}
	
	public void validaCpfeEmail(Cliente cliente) {
		
		if(this.repository.existsByCpf(cliente.getCpf())) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		
		if(this.repository.existsByEmail(cliente.getEmail())) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
		}
	}
}
