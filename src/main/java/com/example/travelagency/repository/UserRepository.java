package com.example.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travelagency.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByLogin(String login);
	User findByLogin(String login);
}
