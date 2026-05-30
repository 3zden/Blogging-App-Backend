package com._zden.BloggingApp.Service;


import com._zden.BloggingApp.Entities.Blog;
import com._zden.BloggingApp.Entities.User;
import com._zden.BloggingApp.Mapper.BlogMapper;
import com._zden.BloggingApp.Repositories.BlogRepo;
import com._zden.BloggingApp.Repositories.UserRepo;
import com._zden.BloggingApp.DTOs.BlogResponseDTO;
import com._zden.BloggingApp.DTOs.CreateBlogDTO;
import com._zden.BloggingApp.DTOs.UpdateBlogDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    BlogRepo repo;
    @Autowired
    UserRepo userRepo;
    BlogMapper mapper  = new BlogMapper();

    // Get all blogs
    public List<BlogResponseDTO> getBlogs(){
        List<Blog> temp = repo.findAll();
        List<BlogResponseDTO> blgs = temp.stream().
                map(blog -> mapper.toDto(blog,blog.getAuthor())).toList();
        return blgs;
    }

    // Get Blog By id                blog.getAuthor(),
    public BlogResponseDTO getBlog(int id){
        Blog blog = repo.findById(id).orElse(new Blog());
        return mapper.toDto(blog, blog.getAuthor());
    }

    // Post Blog
    public ResponseEntity<BlogResponseDTO> postBlog(CreateBlogDTO blog){
        System.out.println(userRepo.existsById(blog.userId() +blog.userId()));
        if (userRepo.existsById(blog.userId())) {
            Blog response = new Blog(blog.title(), blog.content(), entityManager.getReference(User.class, blog.userId()));
            repo.save(response);
            return ResponseEntity.
                    status(HttpStatus.CREATED).
                    body(mapper.toDto(response, response.getAuthor()));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
//        return mapper.toDto(response );
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
