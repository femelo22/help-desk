package com.lfmelo.enums;

public enum EPrioridade {
	
	BAIXA(0, "BAIXA"),
	MEDIA(1, "MEDIA"),
	ALTA(2, "ALTA");
	
	private Integer code;
	
	private String description;

	private EPrioridade(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public static EPrioridade toEnum(String descricao) {
		if(descricao == null) {
			return null;
		}
		
		for(EPrioridade prioridade: EPrioridade.values()) {
			if(descricao.equals(prioridade.getDescription())) {
				return prioridade;
			}
		}
		
		throw new IllegalArgumentException("Prioridade inválida!");
	}
	

}
