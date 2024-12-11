package org.jsp.quiz.dao.impl;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.UserDao;
import org.jsp.quiz.entity.User;
import org.jsp.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> findUserByEmailAndPassword(String username, String password) {
		return userRepo.findByUsernameAndPassword(username,password);
	}
}
