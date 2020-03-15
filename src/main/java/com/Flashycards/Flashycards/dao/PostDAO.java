package com.Flashycards.Flashycards.dao;

public class PostDAO {

    private String title;
    private String description;
    private String content;

    public PostDAO(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
