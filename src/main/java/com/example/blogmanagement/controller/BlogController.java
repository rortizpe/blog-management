package com.example.blogmanagement.controller;

import com.example.blogmanagement.model.entity.Blog;
import com.example.blogmanagement.model.request.BlogRequest;
import com.example.blogmanagement.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("blog")
@AllArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping
    public List<Blog> findAll() {
        return blogService.findAll();
    }

    @PostMapping
    public Blog saveBlog(@RequestBody BlogRequest blogRequest) {
        return blogService.saveBlog(blogRequest);
    }
}
