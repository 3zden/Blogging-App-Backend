package com._zden.BloggingApp.Entities;

import com._zden.BloggingApp.Service.authTest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "users")
public class UserEntity {

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
    private enum role{user,admin};
    private boolean enabled;
    public UserEntity(){}
    public UserEntity(String email,String password,String firstName, String lastName) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
}
