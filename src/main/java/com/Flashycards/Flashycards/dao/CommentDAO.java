package com.Flashycards.Flashycards.dao;

public class CommentDAO {
    private String comment;

    public CommentDAO(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
