package com.Flashycards.Flashycards.models;

import javax.persistence.*;

@Entity
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Categories category;
    private String question;
    private Integer like_count;
    private Integer dislike_count;
}
