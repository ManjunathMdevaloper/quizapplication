package org.jsp.quiz.exceptions;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class InvalidCredientialsxception extends RuntimeException{
	private String s;
	public InvalidCredientialsxception(String s) {
		this.s = s;
	}
	@Override
	public String getMessage() {
		return this.s;
	}
}
