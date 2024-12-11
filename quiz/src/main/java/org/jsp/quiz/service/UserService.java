package org.jsp.quiz.service;

import org.jsp.quiz.dto.UserLogin;
import org.jsp.quiz.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {


	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findAllUser();

	ResponseEntity<?> login(UserLogin login);

}
