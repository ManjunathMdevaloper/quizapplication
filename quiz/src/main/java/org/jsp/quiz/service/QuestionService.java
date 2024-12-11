package org.jsp.quiz.service;

import java.util.List;

import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.dto.UserLogin;
import org.jsp.quiz.entity.Quiz;
import org.jsp.quiz.entity.User;
import org.springframework.http.ResponseEntity;

public interface QuestionService {

	ResponseEntity<?> save(Quiz quiz);

	ResponseEntity<?> findAll();

	ResponseEntity<?> findById(int id);

	ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses);

	ResponseEntity<?> takeTest();


	
}
