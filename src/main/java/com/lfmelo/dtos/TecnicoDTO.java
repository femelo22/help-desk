package com.lfmelo.dtos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lfmelo.domain.Tecnico;
import com.lfmelo.enums.EPerfil;

public class TecnicoDTO {
	private static final long serialVersionUID = 1L;

	protected Integer id;
	@NotNull(message = "O campo NOME é requerido")
	protected String nome;
	@NotNull(message = "O campo CPF é requerido")
	@CPF
	protected String cpf;
	@NotNull(message = "O campo EMAIL é requerido")
	protected String email;
	@NotNull(message = "O campo SENHA é requerido")
	protected String senha;
	protected Set<String> perfis = new HashSet<>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();

	public TecnicoDTO() {
		super();
		addPerfil(EPerfil.CLIENTE);
	}

	public TecnicoDTO(Tecnico obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getDescription()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		addPerfil(EPerfil.CLIENTE);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		this.perfis.add(perfil.getDescription());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
