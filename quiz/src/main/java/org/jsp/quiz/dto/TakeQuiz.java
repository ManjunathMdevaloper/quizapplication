package org.jsp.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TakeQuiz {
	private int id;
	private String question;
	private String a;
	private String b;
	private String c;
	private String d;
}
