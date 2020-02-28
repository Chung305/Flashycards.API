package com.Flashycards.Flashycards.dao;

import com.Flashycards.Flashycards.models.enums.Categories;

public class flashcardDAO {
    private Categories category;
    private String question;
    private String answer;

    public flashcardDAO(Categories category, String question, String answer) {
        this.category = category;
        this.question = question;
        this.answer = answer;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
