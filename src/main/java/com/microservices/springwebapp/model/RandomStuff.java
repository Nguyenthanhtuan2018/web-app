package com.microservices.springwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 5/1/2019
 * Github: https://github.com/loda-kun
 */
@Data
@AllArgsConstructor
public class RandomStuff {
	private String message;
	
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RandomStuff(String message) {
		
    	this.message = message;
	}

	
}
