package com._zden.BloggingApp.Service;


import com._zden.BloggingApp.Entities.Blog;
import com._zden.BloggingApp.Mapper.BlogMapper;
import com._zden.BloggingApp.Repo.BlogRepo;
import com._zden.BloggingApp.blogDTO.Blogresponse;
import com._zden.BloggingApp.blogDTO.createBlogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepo repo;
    BlogMapper mapper  = new BlogMapper();

    // Get all blogs
    public List<Blogresponse> getBlogs(){
        List<Blog> temp = repo.findAll();
        List<Blogresponse> blgs = temp.stream().
                map(blog -> mapper.toDto(blog)).toList();
        return blgs;
    }

    // Get Blog By id
    public Blogresponse getBlog(int id){
        return mapper.toDto(repo.findById(id).orElse(null));
    }

    // Post Blog
    public void postBlog(createBlogDto blog){
        repo.save(new Blog(blog.title(), blog.content(), blog.author()));
    }
    // update a blog
    public void updateBlog(Blog blog, int id) {
        repo.save(blog);
    }

    // delete a blog
    public void deleteBlog(int id){
        repo.deleteById(id);
    }
}
