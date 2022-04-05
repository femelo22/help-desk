package com.lfmelo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lfmelo.domain.Chamado;
import com.lfmelo.dtos.ChamadoDTO;
import com.lfmelo.services.ChamadoService;

@RestController
@RequestMapping("/chamados")
public class ChamadoResource {
	
	@Autowired
	private ChamadoService service;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ChamadoDTO>> findAll() {
		List<Chamado> chamados = this.service.findAll();
		List<ChamadoDTO> dtos = chamados.stream().map(x -> new ChamadoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
		Chamado chamado = this.service.findById(id);
		return ResponseEntity.ok().body(new ChamadoDTO(chamado));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ChamadoDTO> crete(@RequestBody @Valid ChamadoDTO dto) {
		Chamado chamado = this.service.create(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(chamado.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Chamado> update(@RequestBody @Valid ChamadoDTO dto, @PathVariable Integer id) {
		return ResponseEntity.ok().body(this.service.update(dto, id));
	}
	
//	@DeleteMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public ResponseEntity<Chamado> delete(@PathVariable Integer id) {
//		this.service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
	
}
