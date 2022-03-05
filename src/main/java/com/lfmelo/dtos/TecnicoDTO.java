package com.lfmelo.dtos;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.lfmelo.enums.EPerfil;

public class TecnicoDTO {
	
	
	@NotNull(message = "O campo NOME é requerido")
	protected String nome;
	
	@NotNull(message = "O campo CPF é requerido")
	protected String cpf;
	
	@NotNull(message = "O campo EMAIL é requerido")
	protected String email;
	
	@NotNull(message = "O campo SENHA é requerido")
	protected String senha;
	
	protected Set<Integer> perfis = new HashSet<>();
	
	public TecnicoDTO() {
		super();
		addPerfil(EPerfil.CLIENTE);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<EPerfil> getPerfis() {
		return perfis.stream().map(x -> EPerfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(EPerfil perfil) {
		this.perfis.add(perfil.getCode());
	}
	
	

	
}
