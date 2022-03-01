package com.lfmelo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lfmelo.domain.Chamado;
import com.lfmelo.domain.Cliente;
import com.lfmelo.domain.Tecnico;
import com.lfmelo.enums.EPerfil;
import com.lfmelo.enums.EPrioridade;
import com.lfmelo.enums.EStatus;
import com.lfmelo.repositories.ChamadoRepository;
import com.lfmelo.repositories.ClienteRepository;
import com.lfmelo.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Luiz Fernando", "69807858003", "tecluiz@gmail.com", "123");
		tec1.addPerfil(EPerfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torval", "93664381050", "clientelinus@hotmail.com", "321");
		
		Chamado chamado1 = new Chamado(null, EPrioridade.MEDIA, EStatus.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		chamadoRepository.saveAll(Arrays.asList(chamado1));
		
		
	}

}
