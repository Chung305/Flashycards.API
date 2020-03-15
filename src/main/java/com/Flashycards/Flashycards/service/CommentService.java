package com.Flashycards.Flashycards.service;

import com.Flashycards.Flashycards.dao.CommentDAO;
import com.Flashycards.Flashycards.models.Comments;
import com.Flashycards.Flashycards.models.Post;
import com.Flashycards.Flashycards.repositories.CommentsRepository;
import com.Flashycards.Flashycards.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private PostRepository postRepository;


    public Comments createComment(Long postId, String username, CommentDAO comment) {
        Optional<Post> postOptional = postRepository.findById(postId);

        if(postOptional.isPresent()){
            Post post = postOptional.get();
            Comments comments = new Comments();

            comments.setText(comment.getComment());
            comments.setUsername(username);
            comments.setCreatedOn(LocalDate.now());
            comments.setPost(post);

            return commentsRepository.save(comments);
        }else{
            return null;
        }
    }


    public Comments updateComment(Long commentId, CommentDAO comment) {
        Comments comments = commentsRepository.findById(commentId).get();

        comments.setText(comment.getComment());
        comments.setUpdatedOn(LocalDate.now());

        return commentsRepository.save(comments);
    }

    public Boolean deleteComment(Long commentId) {
        Optional<Comments> optionalComments = commentsRepository.findById(commentId);

        if(optionalComments.isPresent()){
            commentsRepository.delete(optionalComments.get());
            return true;
        }else{
            return false;
        }
    }
}
