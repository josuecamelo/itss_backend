package com.josuecamelo.estacionamento.models;

import java.util.List;

public class GenericResponse {

	private Boolean success;
	private String message;
	private Object object;
	private List<Object> list;
	
	public Boolean getSuccess() {
		return success;
	}
	
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	
	public List<Object> getList() {
		return list;
	}
	
	public void setList(List<Object> list) {
		this.list = list;
	}	
}
