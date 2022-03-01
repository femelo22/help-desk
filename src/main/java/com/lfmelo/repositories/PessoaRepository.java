package com.lfmelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lfmelo.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
