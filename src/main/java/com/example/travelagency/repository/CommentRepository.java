package com.example.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travelagency.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
