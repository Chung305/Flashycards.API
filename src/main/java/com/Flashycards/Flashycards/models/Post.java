package com.Flashycards.Flashycards.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Categories category;
    private String title;
    private String content;
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private String username;
}
