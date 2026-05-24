package com._zden.BloggingApp.Service;


import com._zden.BloggingApp.Entities.Blog;
import com._zden.BloggingApp.Entities.UserEntity;
import com._zden.BloggingApp.Mapper.BlogMapper;
import com._zden.BloggingApp.Repo.BlogRepo;
import com._zden.BloggingApp.Repo.UserRepo;
import com._zden.BloggingApp.blogDTO.BlogResponseDTO;
import com._zden.BloggingApp.blogDTO.CreateBlogDTO;
import com._zden.BloggingApp.blogDTO.UpdateBlogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepo repo;
    @Autowired
    UserRepo userRepo;
    BlogMapper mapper  = new BlogMapper();

    // Get all blogs
    public List<BlogResponseDTO> getBlogs(){
        List<Blog> temp = repo.findAll();
        List<BlogResponseDTO> blgs = temp.stream().
                map(blog -> mapper.toDto(blog,userRepo.findById(blog.getAuthorId()).orElse(new UserEntity()))).toList();
        return blgs;
    }

    // Get Blog By id                blog.getAuthor(),
    public BlogResponseDTO getBlog(int id){
        Blog blog = repo.findById(id).orElse(new Blog());
        return mapper.toDto(blog, userRepo.findById(blog.getAuthorId()).orElse(new UserEntity()));
    }

    // Post Blog
    public void postBlog(CreateBlogDTO blog){
        Blog response = new Blog(blog.title(), blog.content(), blog.authorId());
        repo.save(response);
//        return mapper.toDto(response, );
    }
    // update a blog
    public void updateBlog(UpdateBlogDTO blog, int id) {
        repo.findById(id).ifPresent(existing -> {
            existing.setTitle(blog.title());
            existing.setContent(blog.content());
//            existing.setAuthor(blog.Author());
            existing.setUpdatedAt(LocalDateTime.now());
            repo.save(existing);
        });
    }

    // delete a blog
    public void deleteBlog(int id){
        repo.deleteById(id);
    }
}
