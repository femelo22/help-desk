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

		Tecnico tec1 = new Tecnico(null, "Luiz Fernando", "69807858003", "tecluiz@gmail.com", encoder.encode("123"));
		tec1.addPerfil(EPerfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "Polyana Naiane", "69807858043", "tecpoly@gmail.com", encoder.encode("12345"));
		tec1.addPerfil(EPerfil.TECNICO);

		Cliente cli1 = new Cliente(null, "Linus Torval", "93664381050", "clientelinus@hotmail.com", encoder.encode("321"));

		Chamado chamado1 = new Chamado(null, EPrioridade.MEDIA, EStatus.ANDAMENTO, "Chamado 01", "Primeiro chamado",tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));

		clienteRepository.saveAll(Arrays.asList(cli1));

		chamadoRepository.saveAll(Arrays.asList(chamado1));
	}
}
