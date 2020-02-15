package com.Flashycards.Flashycards.models;

import java.time.LocalDate;

public class Comments {
    private Long id;
    private String content;
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private String username;
    private Post post;
}
