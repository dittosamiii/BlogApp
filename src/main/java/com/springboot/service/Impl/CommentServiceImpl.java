package com.springboot.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.dto.CommentDto;
import com.springboot.entity.Comment;
import com.springboot.entity.Post;
import com.springboot.entity.User;
import com.springboot.mapper.CommentMapper;
import com.springboot.repository.CommentRepository;
import com.springboot.repository.PostRepository;
import com.springboot.repository.UserRepository;
import com.springboot.service.CommentService;
import com.springboot.util.SecurityUtils;

@Service
public class CommentServiceImpl implements CommentService {

	private PostRepository postRepository;
	private CommentRepository commentRepository;
	private UserRepository userRepository;

	public CommentServiceImpl(PostRepository postRepository, UserRepository userRepository,
			CommentRepository commentRepository) {
		super();
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void createComment(String postUrl, CommentDto commentDto) {
		Post post = postRepository.findByUrl(postUrl).get();
		Comment comment = CommentMapper.mapToComment(commentDto);
		comment.setPost(post);
		commentRepository.save(comment);
	}

	@Override
	public List<CommentDto> findAllComments() {
		List<Comment> comments = commentRepository.findAll();
		return comments.stream().map(CommentMapper::mapToCommentDto).collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long commentId) {
		commentRepository.deleteById(commentId);
	}

	@Override
	public List<CommentDto> findCommentByUserId() {
		String email = SecurityUtils.getLoggedInUserDetails().getUsername();
		User user = userRepository.findByEmail(email);
		List<Comment> comments = commentRepository.findCommentByUser(user.getId());
		return comments.stream().map(CommentMapper::mapToCommentDto).collect(Collectors.toList());
	}
}
