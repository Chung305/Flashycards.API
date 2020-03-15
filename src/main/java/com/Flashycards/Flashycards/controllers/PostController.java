package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.dao.PostDAO;
import com.Flashycards.Flashycards.models.Post;
import com.Flashycards.Flashycards.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * creates a post
     * @param username user creating the post
     * @param post
     * @return returns post created;
     */
    @PostMapping("/create/{username}")
    public ResponseEntity<Post> createPost(@PathVariable String username, @RequestBody PostDAO post){
        return new ResponseEntity<>(postService.createPost(username, post), HttpStatus.CREATED);
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long postId, @RequestBody PostDAO post){
        return new ResponseEntity<>(postService.updatePost(postId, post), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postService.deletePost(postId);
    }

    @GetMapping("/all-posts")
    public ResponseEntity<Iterable<Post>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }
}
