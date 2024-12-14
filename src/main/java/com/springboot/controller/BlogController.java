package com.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.dto.CommentDto;
import com.springboot.dto.PostDto;
import com.springboot.service.PostService;

@Controller
public class BlogController {
	private PostService postService;

	public BlogController(PostService postService) {
		super();
		this.postService = postService;
	}

	// handler method to handle http://localhost:8080/
	@GetMapping("/")
	public String viewBlogPosts(Model model) {
		List<PostDto> posts = postService.findAll();
		model.addAttribute("posts", posts);
		return "blog/view_posts";
	}

	// handler method to handle blog post request
	@GetMapping("/post/{postUrl}")
	public String showBlogPost(@PathVariable String postUrl, Model model) {
		PostDto post = postService.findPostByUrl(postUrl);
		CommentDto commentDto = new CommentDto();
		model.addAttribute("post", post);
		model.addAttribute("comment", commentDto);
		return "blog/blog_post";
	}

	// handler method to handle client side search request
	@GetMapping("/posts/search")
	public String searchPosts(@RequestParam String query, Model model) {
		List<PostDto> posts = postService.searchPosts(query);
		model.addAttribute("posts", posts);
		return "/blog/view_posts";
	}
}
