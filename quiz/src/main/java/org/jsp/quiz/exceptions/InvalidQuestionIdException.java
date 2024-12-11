package org.jsp.quiz.exceptions;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class InvalidQuestionIdException extends RuntimeException{
	private String s;
	public InvalidQuestionIdException(String s) {
		this.s=s;
	}
	@Override
	public String getMessage() {
		return this.s;
	}
}
