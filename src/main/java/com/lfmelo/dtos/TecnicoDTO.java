package com.lfmelo.dtos;

import java.util.HashSet;
import java.util.Set;

import com.lfmelo.enums.EPerfil;

public class TecnicoDTO {
	
	
	protected String nome;
	
	protected String cpf;
	
	protected String email;
	
	protected String senha;
	
	protected Set<Integer> perfis = new HashSet<>();
	
	public TecnicoDTO() {
		super();
		perfis.add(EPerfil.CLIENTE.getCode());
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

	public Set<Integer> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}
	
	

	
}
