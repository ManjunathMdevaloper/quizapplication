package org.jsp.quiz.dao.impl;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.QuestionDao;
import org.jsp.quiz.entity.Quiz;
import org.jsp.quiz.entity.User;
import org.jsp.quiz.repository.QuizRepository;
import org.jsp.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	private QuizRepository repository;
	
	@Override
	public Quiz save(Quiz quiz) {
		return repository.save(quiz);
	}

	@Override
	public List<Quiz> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Quiz> findById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Quiz> findActiveQuestions() {
		return repository.findAllActiveQuestions();
	}
}
