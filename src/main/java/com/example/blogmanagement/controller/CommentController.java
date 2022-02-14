package com.example.blogmanagement.controller;

import com.example.blogmanagement.model.entity.Comment;
import com.example.blogmanagement.model.request.CommentRequest;
import com.example.blogmanagement.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comment")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public List<Comment> findAll() {
        return commentService.findAll();
    }

    @PostMapping
    public Comment registerComment(@RequestBody CommentRequest comment) {

        return commentService.registerComment(comment);
    }

}
