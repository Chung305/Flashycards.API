package com.Flashycards.Flashycards.models;

import com.Flashycards.Flashycards.models.enums.Categories;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Categories category;
    private String title;
    private String content;
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private String username;
}
