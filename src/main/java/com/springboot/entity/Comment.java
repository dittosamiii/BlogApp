package com.springboot.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Lob
	private String content;
	@CreationTimestamp
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;

	// No-args constructor
	public Comment() {
	}

	// All-args constructor
	public Comment(Long id, String name, String email, String content, LocalDateTime createdOn, LocalDateTime updatedOn,
			Post post) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.content = content;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.post = post;
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	// Builder pattern
	public static class Builder {
		private Long id;
		private String name;
		private String email;
		private String content;
		private LocalDateTime createdOn;
		private LocalDateTime updatedOn;
		private Post post;

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

		public Builder post(Post post) {
			this.post = post;
			return this;
		}

		public Comment build() {
			return new Comment(id, name, email, content, createdOn, updatedOn, post);
		}
	}
}
