package com.springboot.dto;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.validation.constraints.NotEmpty;

public class PostDto {
	private Long id;
	@NotEmpty(message = "Title field should not be empty.")
	private String title;
	private String url;
	@NotEmpty(message = "Content field should not be empty.")
	private String content;
	@NotEmpty(message = "Short Description field should not be empty.")
	private String shortDescription;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private Set<CommentDto> comments;

	// No-args constructor
	public PostDto() {
		super();
	}

	// All-args constructor
	public PostDto(Long id, String title, String url, String content, String shortDescription, LocalDateTime createdOn,
			LocalDateTime updatedOn, Set<CommentDto> comments) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.content = content;
		this.shortDescription = shortDescription;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.comments = comments;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
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

	public Set<CommentDto> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDto> comments) {
		this.comments = comments;
	}

	// Builder pattern
	public static class Builder {
		private Long id;
		private String title;
		private String url;
		private String content;
		private String shortDescription;
		private LocalDateTime createdOn;
		private LocalDateTime updatedOn;
		private Set<CommentDto> comments;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder url(String url) {
			this.url = url;
			return this;
		}

		public Builder content(String content) {
			this.content = content;
			return this;
		}

		public Builder shortDescription(String shortDescription) {
			this.shortDescription = shortDescription;
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

		public Builder comments(Set<CommentDto> comments) {
			this.comments = comments;
			return this;
		}

		public PostDto build() {
			PostDto postDto = new PostDto();
			postDto.setId(this.id);
			postDto.setTitle(this.title);
			postDto.setUrl(this.url);
			postDto.setContent(this.content);
			postDto.setShortDescription(this.shortDescription);
			postDto.setCreatedOn(this.createdOn);
			postDto.setUpdatedOn(this.updatedOn);
			postDto.setComments(this.comments);
			return postDto;
		}
	}
}
