package com.lfmelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lfmelo.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	boolean existsByCpf(String cpf);
	boolean existsByEmail(String email);
}
