package com.Flashycards.Flashycards.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false, unique = true)
    @Size(min = 3)
    private String username;

    @Column(nullable = false, unique = true)
    @Size(min = 8)
    private String password;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Score> scores = new ArrayList<>();

    private LocalDate registerDate;




}
