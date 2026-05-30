package com._zden.BloggingApp.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long userId;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private enum role{USER, ADMIN};
    private boolean enabled;
    @OneToMany(mappedBy = "author")
    private List<Blog> blogs;

    public User(){}

    public User(String email, String password, String firstName, String lastName) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        this.enabled = true;
    }
}
