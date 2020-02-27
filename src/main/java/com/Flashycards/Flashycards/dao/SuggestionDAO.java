package com.Flashycards.Flashycards.dao;

public class SuggestionDAO {
    private Integer category;
    private String question;

    public SuggestionDAO(Integer category, String question) {
        this.category = category;
        this.question = question;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
