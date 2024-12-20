package com.springboot.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.dto.CommentDto;
import com.springboot.entity.Comment;
import com.springboot.entity.Post;
import com.springboot.entity.User;
import com.springboot.repository.CommentRepository;
import com.springboot.repository.PostRepository;
import com.springboot.repository.UserRepository;
import com.springboot.service.CommentService;
import com.springboot.util.SecurityUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

	private PostRepository postRepository;
	private CommentRepository commentRepository;
	private UserRepository userRepository;
	private ModelMapper modelMapper;

	@Override
	public void createComment(String postUrl, CommentDto commentDto) {
		Post post = postRepository.findByUrl(postUrl).get();
		Comment comment = modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);
		commentRepository.save(comment);
	}

	@Override
	public List<CommentDto> findAllComments() {
		List<Comment> comments = commentRepository.findAll();
		return comments.stream().map((entity) -> modelMapper.map(entity, CommentDto.class))
				.collect(Collectors.toList());
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
		return comments.stream().map((entity) -> modelMapper.map(entity, CommentDto.class))
				.collect(Collectors.toList());
	}

}
