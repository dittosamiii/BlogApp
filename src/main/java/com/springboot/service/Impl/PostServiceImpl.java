package com.springboot.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.dto.PostDto;
import com.springboot.entity.Post;
import com.springboot.entity.User;
import com.springboot.mapper.PostMapper;
import com.springboot.repository.PostRepository;
import com.springboot.repository.UserRepository;
import com.springboot.service.PostService;
import com.springboot.util.SecurityUtils;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        super();
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());
    }

    @Override
    public void createPost(PostDto postDto) {
        String email = SecurityUtils.getLoggedInUserDetails().getUsername();
        User user = userRepository.findByEmail(email);
        Post post = PostMapper.mapToPost(postDto);
        post.setCreatedBy(user);
        postRepository.save(post);
    }

    @Override
    public PostDto findPostById(Long postId) {
        Post post = postRepository.findById(postId).get();
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public void updatePostById(PostDto postDto) {
        String email = SecurityUtils.getLoggedInUserDetails().getUsername();
        User user = userRepository.findByEmail(email);
        Post post = PostMapper.mapToPost(postDto);
        post.setCreatedBy(user);
        postRepository.save(post);
    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public PostDto findPostByUrl(String postDtoUrl) {
        Post post = postRepository.findByUrl(postDtoUrl).get();
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public List<PostDto> searchPosts(String query) {
        List<Post> posts = postRepository.searchPosts(query);
        return posts.stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findPostByUserId() {
        String email = SecurityUtils.getLoggedInUserDetails().getUsername();
        User user = userRepository.findByEmail(email);
        List<Post> post = postRepository.findPostByUserID(user.getId());
        return post.stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());
    }
}
