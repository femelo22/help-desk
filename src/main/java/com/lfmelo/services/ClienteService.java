package com.lfmelo.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lfmelo.domain.Cliente;
import com.lfmelo.dtos.ClienteDTO;
import com.lfmelo.exceptions.DataIntegrityViolationException;
import com.lfmelo.exceptions.NotFoundException;
import com.lfmelo.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	public Cliente findById(Integer id) {
		return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Objeto não encontrado de id " + id));
	}
	
	public List<Cliente> findAll() {
		return this.repository.findAll();
	}

	public Cliente create(Cliente cliente) {
		this.validaCpfeEmail(cliente);
		cliente.setSenha(bCrypt.encode(cliente.getSenha()));
		return this.repository.save(cliente);
	}

	public void update(ClienteDTO dto, Integer id) {
		Cliente cliente = this.findById(id); 
		
		if(!dto.getSenha().equals(cliente.getSenha())) {
			cliente.setSenha(bCrypt.encode(cliente.getSenha()));
		}
		
		BeanUtils.copyProperties(dto, cliente);
		this.repository.save(cliente);
	}

	public void delete(Integer id) {
		Cliente cliente = this.findById(id);
		
		if (cliente.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Cliente possui ordens de serviço e não pode ser deletado!");
		}
		
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
