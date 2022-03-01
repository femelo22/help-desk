package com.lfmelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lfmelo.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
