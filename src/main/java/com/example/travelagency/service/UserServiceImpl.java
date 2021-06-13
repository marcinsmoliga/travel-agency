package com.example.travelagency.service;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.travelagency.model.Role;
import com.example.travelagency.model.User;
import com.example.travelagency.repository.RoleRepository;
import com.example.travelagency.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	public UserServiceImpl(UserRepository userRepository,
	                       RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public User getById(Long id) {
		return userRepository.getById(id);
	}

	@Override
	public void createNewAccount(User user) {
		user.setEnabled(true);
		user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getConfirmedPassword()));
		userRepository.save(user);

		Role role = new Role();
		role.setLogin(user.getLogin());
		role.setRole("ROLE_CLIENT");
		roleRepository.save(role);
	}

	@Override
	public boolean loginExists(String login) {
		return userRepository.existsByLogin(login);
	}
}
