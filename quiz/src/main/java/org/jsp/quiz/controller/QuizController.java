package org.jsp.quiz.controller;

import java.util.List;

import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.dto.UserLogin;
import org.jsp.quiz.entity.Quiz;
import org.jsp.quiz.entity.User;
import org.jsp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/questions")
@CrossOrigin("http://localhost:5173")
public class QuizController {
	@Autowired
	private QuestionService service;

	@PostMapping
	public ResponseEntity<?> saveQuestion(@RequestBody Quiz quiz) {
		return service.save(quiz);
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		return service.findById(id);
	}
	@PostMapping("/submit-quiz")
	public ResponseEntity<?> submitQuiz(@RequestBody List<QuizResponse> quizResponses){
		return service.submitQuiz(quizResponses);
	}
	@GetMapping("/taketest")
	public ResponseEntity<?> takeTest(){
		return service.takeTest();
	}
	
}
