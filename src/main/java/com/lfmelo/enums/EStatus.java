package com.lfmelo.enums;

public enum EStatus {
	
	ABERTO(0, "ABERTO"),
	ANDAMENTO(1, "ANDAMENTO"),
	ENCERRADO(2, "ENCERRADO");
	
	private Integer code;
	
	private String description;

	private EStatus(Integer code, String description) {
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
	
	public static EStatus toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for(EStatus status: EStatus.values()) {
			if(code.equals(status.getCode())) {
				return status;
			}
		}
		
		throw new IllegalArgumentException("Status inválido!");
	}
	

}
