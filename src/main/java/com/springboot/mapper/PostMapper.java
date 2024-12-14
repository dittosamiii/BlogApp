package com.springboot.mapper;

import java.util.stream.Collectors;

import com.springboot.dto.PostDto;
import com.springboot.entity.Post;

public class PostMapper {
	// from post to postDto
	public static PostDto mapToPostDto(Post post) {
		return new PostDto.Builder().id(post.getId()).title(post.getTitle()).url(post.getUrl())
				.content(post.getContent()).shortDescription(post.getShortDescription()).createdOn(post.getCreatedOn())
				.updatedOn(post.getUpdatedOn()).comments(post.getComments().stream()
						.map((comment) -> CommentMapper.mapToCommentDto(comment)).collect(Collectors.toSet()))
				.build();
	}

	// from postDto to post
	public static Post mapToPost(PostDto postDto) {
		return new Post.Builder().id(postDto.getId()).title(postDto.getTitle()).url(postDto.getUrl())
				.content(postDto.getContent()).shortDescription(postDto.getShortDescription())
				.createdOn(postDto.getCreatedOn()).updatedOn(postDto.getUpdatedOn()).build();
	}
}
