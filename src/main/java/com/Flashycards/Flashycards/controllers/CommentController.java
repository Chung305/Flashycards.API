package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.dao.CommentDAO;
import com.Flashycards.Flashycards.models.Comments;
import com.Flashycards.Flashycards.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create/{postId}/{username}")
    public ResponseEntity<Comments> createComment (@PathVariable Long postId, @PathVariable String username, @RequestBody CommentDAO comment){
        return new ResponseEntity<>(commentService.createComment(postId, username, comment), HttpStatus.CREATED);
    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<Comments> updateComment (@PathVariable Long commentId, @RequestBody CommentDAO comment){
        return new ResponseEntity<>(commentService.updateComment(commentId, comment), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Boolean> deleteComment (@PathVariable Long commentId){
        return new ResponseEntity<>(commentService.deleteComment(commentId), HttpStatus.ACCEPTED);
    }
}
