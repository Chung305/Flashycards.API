package com.Flashycards.Flashycards.models;

import java.time.LocalDate;

public class Post {
    private Long id;
    private Categories category;
    private String title;
    private String content;
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private String username;
}
