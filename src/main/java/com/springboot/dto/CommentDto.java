package com.springboot.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

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

	public CommentDto() {
		super();
	}

	public CommentDto(Long id, String name, String email, String content, LocalDateTime createdOn,
			LocalDateTime updatedOn) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.content = content;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	// Builder pattern
	public static class Builder {
		private Long id;
		private String name;
		private String email;
		private String content;
		private LocalDateTime createdOn;
		private LocalDateTime updatedOn;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder content(String content) {
			this.content = content;
			return this;
		}

		public Builder createdOn(LocalDateTime createdOn) {
			this.createdOn = createdOn;
			return this;
		}

		public Builder updatedOn(LocalDateTime updatedOn) {
			this.updatedOn = updatedOn;
			return this;
		}

		public CommentDto build() {
			return new CommentDto(id, name, email, content, createdOn, updatedOn);
		}
	}
}
