package com.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.dto.CommentDto;
import com.springboot.dto.PostDto;
import com.springboot.service.CommentService;
import com.springboot.service.PostService;
import com.springboot.util.ROLE;
import com.springboot.util.SecurityUtils;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PostController {
	private PostService postService;
	private CommentService commentService;

	// handler method to handle the posts request
	@GetMapping("/admin/posts")
	public String posts(Model model) {
		String role = SecurityUtils.getRole();
		List<PostDto> posts = null;
		if (ROLE.ROLE_ADMIN.name().equals(role)) {
			posts = postService.findAll();
		} else {
			posts = postService.findPostByUserId();
		}
		model.addAttribute("posts", posts);
		return "/admin/posts";
	}

	// handler method to handle create post request
	@GetMapping("/admin/posts/newpost")
	public String newPost(Model model) {
		PostDto postDto = new PostDto();
		model.addAttribute("post", postDto);
		return "/admin/create_post";
	}

	// handler method to handle the post request for create post submit request
	@PostMapping("/admin/posts")
	public String createPost(@Valid @ModelAttribute("post") PostDto postDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("post", postDto);
			return "/admin/create_post";
		}
		String url = getUrl(postDto.getTitle());
		postDto.setUrl(url);
		postService.createPost(postDto);
		return "redirect:/admin/posts";
	}

	// handler method to handle edit request
	@GetMapping("/admin/posts/{postId}/edit")
	public String editPost(@PathVariable("postId") Long postDtoId, Model model) {
		PostDto postdto = postService.findPostById(postDtoId);
		model.addAttribute("post", postdto);
		return "/admin/edit_post";
	}

	// handler method to handle post request of edit submit request
	@PostMapping("/admin/posts/{postId}")
	public String updatePost(@PathVariable("postId") Long postDtoId, @Valid @ModelAttribute("post") PostDto postDto,
			BindingResult result, Model model) {
		postDto.setId(postDtoId);
		if (result.hasErrors()) {
			model.addAttribute("post", postDto);
			return "/admin/edit_post";
		}
		postService.updatePostById(postDto);
		return "redirect:/admin/posts";
	}

	// handler method to handle delete request
	@GetMapping("/admin/posts/{postId}/delete")
	public String deletePost(@PathVariable("postId") Long postDtoId) {
		postService.deletePostById(postDtoId);
		return "redirect:/admin/posts";

	}

	// handler method to handle view post request
	@GetMapping("/admin/posts/{postUrl}/view")
	public String viewPost(@PathVariable String postUrl, Model model) {
		PostDto postDto = postService.findPostByUrl(postUrl);
		model.addAttribute("post", postDto);
		return "/admin/view_post";

	}

	// handler method to handle search request
	@GetMapping("/admin/posts/search")
	public String searchPosts(@RequestParam String query, Model model) {
		List<PostDto> posts = postService.searchPosts(query);
		model.addAttribute("posts", posts);
		return "/admin/posts";

	}

	// handler method to handle comments
	@GetMapping("/admin/posts/comments")
	public String getComments(Model model) {
		String role = SecurityUtils.getRole();
		List<CommentDto> comments = null;
		if (ROLE.ROLE_ADMIN.name().equals(role)) {
			comments = commentService.findAllComments();
		} else {
			comments = commentService.findCommentByUserId();
		}
		model.addAttribute("comments", comments);
		return "/admin/comments";
	}

	// handler method to delete the comment
	@GetMapping("/admin/posts/comments/{commentId}")
	public String deleteComment(@PathVariable Long commentId) {
		commentService.deleteById(commentId);
		return "redirect:/admin/posts/comments";
	}

	// method to change the title into Url by removing space and adding "-" instead
	public String getUrl(String postTitle) {
		String title = postTitle.trim().toLowerCase();
		String url = title.replaceAll("//s+", "-");
		url = url.replaceAll("[^A-Za-z0-9]", "-");
		return url;
	}
}
