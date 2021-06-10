package com.example.travelagency.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.travelagency.model.User;
import com.example.travelagency.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getById(Long id) {
		return userRepository.getById(id);
	}
}
