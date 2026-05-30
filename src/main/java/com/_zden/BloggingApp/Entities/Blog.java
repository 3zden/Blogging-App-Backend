package com._zden.BloggingApp.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity
@Getter @Setter
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private int likes;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User author;

    //Constructor
    public Blog(String title,String content,User author){
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.likes = 0;
    }
    public Blog(){}
}
