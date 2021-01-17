package com.osanda.classservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = -7384354301123514156L;

	private int code;
	private String message;
	private String reason;

	public InternalServerErrorException(int code, String message, String reason) {
		this.code = code;
		this.message = message;
		this.reason = reason;
	}

}
