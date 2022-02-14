package com.example.blogmanagement.service;


import com.example.blogmanagement.model.entity.Post;
import com.example.blogmanagement.model.request.PostRequest;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post findPostById(int id);

    Post savePost(PostRequest postRequest);
}
