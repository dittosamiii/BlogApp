package com.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
