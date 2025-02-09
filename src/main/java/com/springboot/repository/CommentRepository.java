package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query(value = "Select c.* from comments c inner join posts p where c.post_id=p.id and p.created_by = :userId", nativeQuery = true)
	List<Comment> findCommentByUser(Long userId);

}
