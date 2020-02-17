package com.Flashycards.Flashycards.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private String username;

    @ManyToOne
    private Post post;
}
