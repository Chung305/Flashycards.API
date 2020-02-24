package com.Flashycards.Flashycards.models;

import com.Flashycards.Flashycards.models.enums.Categories;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long score_id;

    @Enumerated(EnumType.STRING)
    private Categories categories;

    private Double score;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIgnore
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


