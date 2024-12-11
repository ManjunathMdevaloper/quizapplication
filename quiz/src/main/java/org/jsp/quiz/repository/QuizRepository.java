package org.jsp.quiz.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.jsp.quiz.entity.Quiz;
import org.jsp.quiz.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
	@Query("select q from Quiz q where q.status='ACTIVE' ")
	List<Quiz> findAllActiveQuestions();
//	@Query("select q from Quiz q where q.status='ACTIVE' ORDER BY FUNCTION('RAND') LIMIT 10 ")
//	List<Quiz> findQuestionsRandom();

	
}
