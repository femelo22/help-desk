package com.lfmelo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lfmelo.domain.Tecnico;
import com.lfmelo.dtos.TecnicoDTO;
import com.lfmelo.services.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {
	
	@Autowired
	TecnicoService service;
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Tecnico> findById(@PathVariable Integer id) {	
		return ResponseEntity.ok().body(this.service.findById(id));
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Tecnico>> findAll() {
		return ResponseEntity.ok().body(this.service.findAll());
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Tecnico> create(@RequestBody TecnicoDTO dto) {
		Tecnico tecnico = new Tecnico(dto);
		this.service.validaCpfeEmail(tecnico);
		Tecnico novoTecnico = this.service.create(tecnico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoTecnico.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

}
