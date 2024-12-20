package com.springboot.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
	private Long id;

	@NotEmpty(message = "Name field should not be empty.")
	private String name;

	@NotEmpty(message = "Email field should not be empty.")
	@Email(message = "Enter a valid email.")
	private String email;

	@NotEmpty(message = "Comment field should not be empty.")
	private String content;

	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

}