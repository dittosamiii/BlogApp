package com.springboot.service;

import java.util.List;

import com.springboot.dto.CommentDto;

public interface CommentService {
	void createComment(String postUrl, CommentDto comment);

	List<CommentDto> findAllComments();

	void deleteById(Long commentId);
	
	List<CommentDto> findCommentByUserId();
}
