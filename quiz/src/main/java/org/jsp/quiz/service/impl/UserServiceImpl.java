package org.jsp.quiz.service.impl;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.UserDao;
import org.jsp.quiz.dto.UserLogin;
import org.jsp.quiz.entity.User;
import org.jsp.quiz.exceptions.InvalidCredientialsxception;
import org.jsp.quiz.responsestructure.ResponseStructure;
import org.jsp.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;
	@Override
	public ResponseEntity<?> saveUser(User user) {
		User u = dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("User Saved Sucsessfully").body(u).build());
	}

	@Override
	public ResponseEntity<?> findAllUser() {
		List<User> ul = dao.findAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("All Users Found").body(ul).build());
	}

	@Override
	public ResponseEntity<?> login(UserLogin login) {
		Optional<User> optional = dao.findUserByEmailAndPassword(login.getUsername(), login.getPassword());
		if (optional.isEmpty())
			throw InvalidCredientialsxception.builder().s("Invalid Username or Password").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("Login Successfull").body(optional.get()).build());
	}

}
