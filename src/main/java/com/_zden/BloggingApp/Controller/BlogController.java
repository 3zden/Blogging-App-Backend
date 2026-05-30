package com._zden.BloggingApp.Controller;


import com._zden.BloggingApp.Service.BlogService;
import com._zden.BloggingApp.DTOs.BlogResponseDTO;
import com._zden.BloggingApp.DTOs.CreateBlogDTO;
import com._zden.BloggingApp.DTOs.UpdateBlogDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogService service;

    @GetMapping("/v1/blogs")
    public List<BlogResponseDTO> getBlogs() {
        return service.getBlogs();
    }

    @GetMapping("/v1/blogs/{id}")
    public ResponseEntity<BlogResponseDTO> getBlog(@PathVariable int id){
        return ResponseEntity.ok().body(service.getBlog(id));
    }

    @PostMapping("/v1/blogs")
    public ResponseEntity<BlogResponseDTO> postBlog(@Valid @RequestBody CreateBlogDTO blog){
        service.postBlog(blog);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/v1/blogs/{id}")
    public ResponseEntity<BlogResponseDTO> updateBlog(@Valid @PathVariable int id,@RequestBody UpdateBlogDTO blog){
        service.updateBlog(blog,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/v1/blogs/{id}")
    public ResponseEntity<BlogResponseDTO> deleteBlog(@PathVariable int id){
        service.deleteBlog(id);
        return ResponseEntity.status(HttpStatus.GONE).body(null);
    }
}



