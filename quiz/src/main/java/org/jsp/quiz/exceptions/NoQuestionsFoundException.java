package org.jsp.quiz.exceptions;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class NoQuestionsFoundException extends RuntimeException {
	private String s;

	public NoQuestionsFoundException(String s) {
		this.s = s;
	}

	@Override
	public String getMessage() {
		return this.s;
	}
}
