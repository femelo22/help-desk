package com.lfmelo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lfmelo.domain.Chamado;
import com.lfmelo.services.ChamadoService;

@RestController
@RequestMapping("/chamados")
public class ChamadoResource {
	
	@Autowired
	private ChamadoService service;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Chamado>> findAll() {
		return ResponseEntity.ok().body(this.service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Chamado> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(this.service.findById(id));
	}
	
}
