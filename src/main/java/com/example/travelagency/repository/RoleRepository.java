package com.example.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travelagency.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
