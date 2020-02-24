package com.Flashycards.Flashycards.models;

import com.Flashycards.Flashycards.models.enums.Categories;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long score_id;

    @Enumerated(EnumType.STRING)
    private Categories categories;

    private Double score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Score() {
    }

    public Score(Categories categories, Double score, User user){
        this.categories = categories;
        this.score = score;
        this.user = user;
    }

    public Long getScore_id() {
        return score_id;
    }

    public void setScore_id(Long score_id) {
        this.score_id = score_id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + score_id +
                ", categories=" + categories +
                ", score=" + score +
                ", users=" + user +
                '}';
    }
}


