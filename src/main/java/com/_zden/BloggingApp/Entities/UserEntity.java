package com._zden.BloggingApp.Entities;

import com._zden.BloggingApp.Service.authTest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    public UserEntity(){}
    public UserEntity(String email,String password,String firstName, String lastName) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
