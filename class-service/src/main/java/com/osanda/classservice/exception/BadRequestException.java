package com.osanda.classservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Osanda Wddamulla
 *	
 */

@Getter
@Setter
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -2731103709944802729L;

	private int code;
	private String message;
	private String reason;

	public BadRequestException(int code, String message, String reason) {
		this.code = code;
		this.message = message;
		this.reason = reason;
	}

}
