package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.dto.RegistrationDto;
import com.springboot.entity.User;
import com.springboot.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {

	private UserService userService;

	public AuthController(UserService userService) {
		super();
		this.userService = userService;
	}

	// handler method to show login page
	@GetMapping("/login")
	public String goToLoginPage() {
		return "login";
	}

	// handler method to show registration form
	@GetMapping("/register")
	public String getRegistrationForm(Model model) {
		RegistrationDto user = new RegistrationDto();
		model.addAttribute("user", user);
		return "register";
	}

	// handler method to save the user and show success message
	@PostMapping("/register/save")
	public String registeredSuccessfully(@Valid @ModelAttribute("user") RegistrationDto registeredUser,
			BindingResult result, Model model) {
		User existingUser = userService.findByEmail(registeredUser.getEmail());

		if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
			result.rejectValue("email", null, "User with same email id already exists.");
		}
		if (result.hasErrors()) {
			model.addAttribute("user", registeredUser);
			return "register";
		}
		userService.createUser(registeredUser);
		return "redirect:/register?success";
	}
}
