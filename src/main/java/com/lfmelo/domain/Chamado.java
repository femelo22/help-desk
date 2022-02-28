package com.lfmelo.domain;

import java.time.LocalDate;

import com.lfmelo.enums.EPrioridade;
import com.lfmelo.enums.EStatus;

public class Chamado {
	
	private Integer id;
	
	private LocalDate dataAbertura = LocalDate.now();
	
	private LocalDate dataFechamento;
	
	private EPrioridade prioridade;
	
	private EStatus status;
	
	private String titulo;
	
	private String observacoes;

}
