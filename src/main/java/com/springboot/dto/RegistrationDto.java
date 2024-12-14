package com.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class RegistrationDto {
	private Long id;
	@NotEmpty(message = "First Name field should not be empty")
	private String firstName;
	@NotEmpty(message = "Last Name field should not be empty")
	private String lastName;
	@NotEmpty(message = "Email field should not be empty.")
	@Email(message = "Enter a valid email.")
	private String email;
	@NotEmpty(message = "Password field should not be empty.")
	private String password;

	public RegistrationDto() {
		super();
	}

	public RegistrationDto(Long id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
