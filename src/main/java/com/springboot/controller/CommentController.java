package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.dto.CommentDto;
import com.springboot.dto.PostDto;
import com.springboot.service.CommentService;
import com.springboot.service.PostService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CommentController {

	private CommentService commentService;
	private PostService postService;

	// handler method to save the comment
	@PostMapping("/{postUrl}/comments")
	public String savePost(@PathVariable String postUrl, @Valid @ModelAttribute("comment") CommentDto commentDto,
			BindingResult result, Model model) {

		PostDto postDto = postService.findPostByUrl(postUrl);
		if (result.hasErrors()) {
			model.addAttribute("post", postDto);
			model.addAttribute("comment", commentDto);
			return "blog/blog_post";
		}
		commentService.createComment(postUrl, commentDto);
		return "redirect:/post/" + postUrl;
	}
}
