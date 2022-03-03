package com.lfmelo.resources.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private LocalDateTime date;
	private Integer status;
	private String message;
	private String error;
	private String path;
	

	public StandardError() {
		super();
	}
	
	public StandardError(LocalDateTime date, Integer status, String error, String message, String path) {
		super();
		this.date = date;
		this.status = status;
		this.message = message;
		this.error = error;
		this.path = path;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	

}
