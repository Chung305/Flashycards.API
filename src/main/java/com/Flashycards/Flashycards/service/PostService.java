package com.Flashycards.Flashycards.service;

import com.Flashycards.Flashycards.dao.PostDAO;
import com.Flashycards.Flashycards.models.Post;
import com.Flashycards.Flashycards.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(String username, PostDAO post) {
        Post newPost = new Post();

        newPost.setTitle(post.getTitle());
        newPost.setDescription(post.getDescription());
        newPost.setContent(post.getContent());
        newPost.setCreatedOn(LocalDate.now());
        newPost.setUsername(username);

        return postRepository.save(newPost);
    }

    public Post updatePost(Long postId, PostDAO post) {
        Post updatePost = postRepository.findById(postId).get();

        updatePost.setTitle(post.getTitle());
        updatePost.setDescription(post.getDescription());
        updatePost.setContent(post.getContent());

        return postRepository.save(updatePost);
    }

    public ResponseEntity<?> deletePost(Long postId) {
        postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        });
        return null;
    }

    public Iterable<Post> getAllPost() {
        return postRepository.findAll();
    }
}
