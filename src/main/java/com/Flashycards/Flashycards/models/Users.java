package com.Flashycards.Flashycards.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(length = 50, nullable = false, unique = true)
    private String password;

    @OneToMany
    private List<Score> scores;

    private LocalDate registerDate;

    //@Enumerated(EnumType.STRING)
    //private List<Roles> roles;


}
