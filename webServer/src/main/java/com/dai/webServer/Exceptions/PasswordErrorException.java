package com.dai.webServer.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class PasswordErrorException extends RuntimeException {

	public PasswordErrorException(String exception) {
		super(exception);
	}

}


