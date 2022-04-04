package com.lfmelo.enums;

public enum EPerfil {
	
	ADMIN(0, "ROLE_ADMIN"),
	CLIENTE(1, "ROLE_CLIENTE"),
	TECNICO(2, "ROLE_TECNICO");
	
	private Integer code;
	
	private String description;

	private EPerfil(Integer code, String description) {
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
	
	
	public static EPerfil toEnum(String descricao) {
		if(descricao == null) {
			return null;
		}
		
		for(EPerfil perfil: EPerfil.values()) {
			if(descricao.equals(perfil.getDescription())) {
				return perfil;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido!");
	}
	
	
	

}
