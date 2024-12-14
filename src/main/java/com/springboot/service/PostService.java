package com.springboot.service;

import java.util.List;

import com.springboot.dto.PostDto;

public interface PostService {
	List<PostDto> findAll();

	void createPost(PostDto postDto);

	PostDto findPostById(Long postId);

	void updatePostById(PostDto postDto);

	void deletePostById(Long postId);

	PostDto findPostByUrl(String postDtoUrl);

	List<PostDto> searchPosts(String query);

	List<PostDto> findPostByUserId();
}
