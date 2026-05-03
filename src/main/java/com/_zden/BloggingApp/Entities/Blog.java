package com._zden.BloggingApp.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.UUID;
@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String blogName;
    private String blogContent;
    private int likes;
    private String author;

    //Constructor
    public Blog( String blogName,String blogContent, String author){
        this.author = author;
        this.blogName = blogName;
        this.blogContent = blogContent;
        this.likes = 0;
    }
    public Blog(){}
}
