package org.jsp.quiz.exceptionhandler;

import org.jsp.quiz.exceptions.InvalidCredientialsxception;
import org.jsp.quiz.exceptions.InvalidQuestionIdException;
import org.jsp.quiz.exceptions.NoQuestionsFoundException;
import org.jsp.quiz.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuizExceptionHandler {
	@ExceptionHandler(NoQuestionsFoundException.class)
	public ResponseEntity<?> noQuestionsFoundException(NoQuestionsFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("No Questions Found")
						.body("No Questions Available in DataBase").build());
	}

	@ExceptionHandler(InvalidQuestionIdException.class)
	public ResponseEntity<?> invalidQuestionIdException(InvalidQuestionIdException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value())
						.message("No Question Found With This ID").body("No Question Found").build());
	}
	@ExceptionHandler(InvalidCredientialsxception.class)
	public ResponseEntity<?> invalidCredientialsxception(InvalidCredientialsxception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().httpStatus(HttpStatus.BAD_REQUEST.value()).message("Invalid Credentials").body("Invalid UserName or Password").build());
	}
}
