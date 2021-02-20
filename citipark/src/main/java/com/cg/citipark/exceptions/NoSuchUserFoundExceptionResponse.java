package com.cg.citipark.exceptions;

public class NoSuchUserFoundExceptionResponse {
	private Long userId;

	public NoSuchUserFoundExceptionResponse(Long userId) {
		super();
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
}
