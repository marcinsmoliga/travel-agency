package com.example.travelagency.service;

import com.example.travelagency.model.User;

public interface UserService {
	User getById(Long id);
	void createNewAccount(User user);
	boolean loginExists(String login);

}
