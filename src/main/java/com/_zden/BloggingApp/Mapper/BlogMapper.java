package com._zden.BloggingApp.Mapper;

import com._zden.BloggingApp.Entities.Blog;
import com._zden.BloggingApp.Entities.User;
import com._zden.BloggingApp.DTOs.BlogResponseDTO;

public class BlogMapper {
    public BlogResponseDTO toDto(Blog blog, User user){
        return new BlogResponseDTO(
                blog.getId(),
                blog.getTitle(),
                blog.getContent(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
