package com.springboot.mapper;

import com.springboot.dto.CommentDto;
import com.springboot.entity.Comment;

public class CommentMapper {
    // from comment to commentDto
    public static CommentDto mapToCommentDto(Comment comment) {
        return new CommentDto.Builder().id(comment.getId()).name(comment.getName()).email(comment.getEmail())
                .content(comment.getContent()).createdOn(comment.getCreatedOn()).updatedOn(comment.getUpdatedOn())
                .build();
    }

    // from commentDto to comment
    public static Comment mapToComment(CommentDto commentDto) {
        return new Comment.Builder().id(commentDto.getId()).name(commentDto.getName()).email(commentDto.getEmail())
                .content(commentDto.getContent()).createdOn(commentDto.getCreatedOn())
                .updatedOn(commentDto.getUpdatedOn()).build();
    }
}
