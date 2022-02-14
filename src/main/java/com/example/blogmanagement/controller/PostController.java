package com.example.blogmanagement.controller;

import com.example.blogmanagement.model.entity.Post;
import com.example.blogmanagement.model.request.PostRequest;
import com.example.blogmanagement.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("post")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }

    @PostMapping
    public Post savePost(@RequestBody PostRequest postRequest) {
        return postService.savePost(postRequest);
    }
}
