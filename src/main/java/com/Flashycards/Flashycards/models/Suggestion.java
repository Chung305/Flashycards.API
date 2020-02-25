package com.Flashycards.Flashycards.models;

import com.Flashycards.Flashycards.models.enums.Categories;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Categories category;

    @NotNull
    private String question;
    private Integer like_count;
    private Integer dislike_count;

    private LocalDate date_created;

    public Suggestion() {
    }

    public Suggestion(Categories categories, String question, Integer likes, Integer dislikes){
        this.category = categories;
        this.question = question;
        this.like_count = likes;
        this.dislike_count = dislikes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public Integer getDislike_count() {
        return dislike_count;
    }

    public void setDislike_count(Integer dislike_count) {
        this.dislike_count = dislike_count;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }
}
