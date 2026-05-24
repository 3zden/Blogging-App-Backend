package com._zden.BloggingApp.Mapper;

import com._zden.BloggingApp.Entities.Blog;
import com._zden.BloggingApp.Entities.UserEntity;
import com._zden.BloggingApp.blogDTO.BlogResponseDTO;

public class BlogMapper {
    public BlogResponseDTO toDto(Blog blog, UserEntity user){
        return new BlogResponseDTO(
                blog.getId(),
                blog.getTitle(),
                blog.getContent(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
