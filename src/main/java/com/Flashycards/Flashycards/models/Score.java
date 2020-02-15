package com.Flashycards.Flashycards.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Score {
    @Id
    private Long userId;
    private Categories categories;
    private Double score;

    public Score(Long userId, Categories categories, Double score) {
        this.userId = userId;
        this.categories = categories;
        this.score = score;
    }

    public Score() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
