package com.lfmelo.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lfmelo.domain.Chamado;
import com.lfmelo.domain.Cliente;
import com.lfmelo.domain.Tecnico;
import com.lfmelo.enums.EPerfil;
import com.lfmelo.enums.EPrioridade;
import com.lfmelo.enums.EStatus;
import com.lfmelo.repositories.ChamadoRepository;
import com.lfmelo.repositories.ClienteRepository;
import com.lfmelo.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "Luiz Fernando", "69807858003", "luiz@gmail.com", encoder.encode("123"));
		tec1.addPerfil(EPerfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "Polyana Naiane", "69807858043", "tecpoly@gmail.com", encoder.encode("12345"));
		tec1.addPerfil(EPerfil.TECNICO);
		
		Tecnico tec3 = new Tecnico(null, "Jose", "69807858544", "jose@gmail.com", encoder.encode("12345"));
		tec3.addPerfil(EPerfil.TECNICO);
		
		Tecnico tec4 = new Tecnico(null, "Ana", "69807785043", "ana@gmail.com", encoder.encode("12345"));
		tec4.addPerfil(EPerfil.TECNICO);
		
		Tecnico tec5 = new Tecnico(null, "Rubens", "12407858043", "rubens@gmail.com", encoder.encode("12345"));
		tec5.addPerfil(EPerfil.TECNICO);
		
		Tecnico tec6 = new Tecnico(null, "Joana", "09707858043", "joana@gmail.com", encoder.encode("12345"));
		tec6.addPerfil(EPerfil.TECNICO);
		
		Cliente cli1 = new Cliente(null, "Maria", "5364381050", "maria@hotmail.com", encoder.encode("321"));

		Chamado chamado1 = new Chamado(null, EPrioridade.MEDIA, EStatus.ANDAMENTO, "Chamado 01", "Primeiro chamado",tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, tec6));

		clienteRepository.saveAll(Arrays.asList(cli1));

		chamadoRepository.saveAll(Arrays.asList(chamado1));
	}
	
}
