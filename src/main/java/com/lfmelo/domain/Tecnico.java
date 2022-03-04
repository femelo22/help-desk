package com.lfmelo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lfmelo.dtos.TecnicoDTO;
import com.lfmelo.enums.EPerfil;

@Entity
public class Tecnico extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "tecnico")
	@JsonIgnore
	private List<Chamado> chamados = new ArrayList<>();

	public Tecnico() {
		super();
		addPerfil(EPerfil.CLIENTE);
	}

	public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(EPerfil.CLIENTE);
	}
	
	public Tecnico(TecnicoDTO obj) {
		super();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCode()).collect(Collectors.toSet());
		addPerfil(EPerfil.CLIENTE);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	

}
