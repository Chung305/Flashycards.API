package com.Flashycards.Flashycards.models;

import com.Flashycards.Flashycards.models.enums.Categories;

import javax.persistence.*;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Categories categories;

    private Double score;

    @ManyToOne
    private User users;

    public Score() {
    }

    public Score(Categories categories, Double score, User user){
        this.categories = categories;
        this.score = score;
        this.users = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", categories=" + categories +
                ", score=" + score +
                ", users=" + users +
                '}';
    }
}


