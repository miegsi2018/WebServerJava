package com.dai.webServer.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class UtilizadorNotFoundException extends RuntimeException {

	public UtilizadorNotFoundException(String exception) {
		super(exception);
	}

}


