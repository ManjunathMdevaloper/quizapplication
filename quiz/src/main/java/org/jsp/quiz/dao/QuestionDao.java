package org.jsp.quiz.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.entity.Quiz;
import org.jsp.quiz.entity.User;
import org.springframework.data.domain.PageRequest;

public interface QuestionDao {
	Quiz save(Quiz quiz);

	List<Quiz> findAll();

	Optional<Quiz> findById(int id);

	List<Quiz> findActiveQuestions();

	



	
}
