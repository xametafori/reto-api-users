package com.reto.tecnico.apiusers.excepcion;

import org.springframework.http.HttpStatus;

public class ModelRestTemplateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus statusCode;
	private final String error;

	public ModelRestTemplateException(HttpStatus statusCode, String error) {
		super(error);
		this.statusCode = statusCode;
		this.error = error;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public String getError() {
		return error;
	}

	@Override
	public String toString() {
		return "ModelRestTemplateException [statusCode=" + statusCode + ", error=" + error + "]";
	}

}
