package com.cognizant.MutualFundNavService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MutualFundNotFoundException extends Exception {
	public MutualFundNotFoundException(String message)
	{
		super(message);
	}
	public MutualFundNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MutualFundNotFoundException(Throwable cause) {
		super(cause);
	}

	public MutualFundNotFoundException(String message, Throwable cause,boolean enableSuppression,boolean writableStackTrace) {
		super(message,cause,enableSuppression,writableStackTrace);
	}
}
