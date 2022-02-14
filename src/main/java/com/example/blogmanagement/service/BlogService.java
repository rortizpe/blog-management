package com.example.blogmanagement.service;

import com.example.blogmanagement.model.entity.Blog;
import com.example.blogmanagement.model.request.BlogRequest;

import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    Blog findBlogById(int blogId);

    Blog saveBlog(BlogRequest blogRequest);


}
