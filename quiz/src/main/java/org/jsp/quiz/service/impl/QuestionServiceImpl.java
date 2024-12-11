package org.jsp.quiz.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.jsp.quiz.dao.QuestionDao;
import org.jsp.quiz.dto.QuizDto;
import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.dto.TakeQuiz;
import org.jsp.quiz.dto.UserLogin;
import org.jsp.quiz.entity.Quiz;
import org.jsp.quiz.entity.User;
import org.jsp.quiz.exceptions.InvalidQuestionIdException;
import org.jsp.quiz.exceptions.NoQuestionsFoundException;
import org.jsp.quiz.responsestructure.ResponseStructure;
import org.jsp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao dao;

	@Override
	public ResponseEntity<?> save(Quiz quiz) {
		quiz = dao.save(quiz);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("Question Saved Sucsessfully").body(quiz).build());
	}

	@Override
	public ResponseEntity<?> findAll() {
		List<Quiz> ql = dao.findActiveQuestions();
		List<QuizDto> dtoList = new ArrayList<>();

		for (Quiz q : ql)
			dtoList.add(new QuizDto(q.getQuestion(), q.getA(), q.getB(), q.getC(), q.getD()));

		if (dtoList.isEmpty())
			throw NoQuestionsFoundException.builder().s("No Questions Found in DB").build();

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("All Questions Found Sucsessfully").body(dtoList).build());
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		Optional<Quiz> q = dao.findById(id);
		if (q.isEmpty())
			throw InvalidQuestionIdException.builder().s("No Questions Found in DB With This ID").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.body(q.get()).message("Question FoundSucsessfully").build());
	}

	@Override
	public ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses) {
		int c = 0;
		for (QuizResponse qr : quizResponses) {
			Optional<Quiz> q = dao.findById(qr.getId());
			Quiz question = q.get();
			if (question.getAnswer().equalsIgnoreCase(qr.getAnswer()))
				c++;
		}

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("Submission Sucsessfully").body("Your Score  => " + c).build());
	}

	@Override
	public ResponseEntity<?> takeTest() {
		List<Quiz> all = dao.findActiveQuestions();
		Set<TakeQuiz> tl = new HashSet();
		for (int i = 1; i <= 10; i++) {
			Quiz q = all.get(i);
			tl.add(new TakeQuiz(q.getId(), q.getQuestion(), q.getA(), q.getB(), q.getC(), q.getD()));
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("Questions Found Sucsessfully").body(tl).build());
	}

	

}
