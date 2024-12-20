package com.springboot.dto;

import java.time.LocalDateTime;
import java.util.Set;

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

}
