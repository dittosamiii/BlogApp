package com.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	Optional<Post> findByUrl(String url);

	@Query("SELECT p FROM Post p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :query, '%')) "
			+ "OR LOWER(p.shortDescription) LIKE LOWER(CONCAT('%', :query, '%'))")
	List<Post> searchPosts(@Param("query") String query);

	@Query(value = "SELECT * FROM posts p WHERE p.created_by = :userId", nativeQuery = true)
	List<Post> findPostByUserID(Long userId);
}
