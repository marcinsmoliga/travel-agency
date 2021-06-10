package com.example.travelagency.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.travelagency.model.Comment;
import com.example.travelagency.repository.CommentRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	private final CommentRepository commentRepository;

	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public void save(Comment comment) {
		commentRepository.save(comment);
	}
}
