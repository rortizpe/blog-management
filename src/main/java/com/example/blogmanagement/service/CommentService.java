package com.example.blogmanagement.service;

import com.example.blogmanagement.model.entity.Comment;
import com.example.blogmanagement.model.request.CommentRequest;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment registerComment(CommentRequest comment);
}
