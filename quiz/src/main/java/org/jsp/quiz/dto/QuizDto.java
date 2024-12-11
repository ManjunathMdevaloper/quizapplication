package org.jsp.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
	private String question;
	private String a;
	private String b;
	private String c;
	private String d;
	
}
