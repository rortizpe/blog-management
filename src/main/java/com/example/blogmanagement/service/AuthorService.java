package com.example.blogmanagement.service;

import com.example.blogmanagement.model.entity.Author;
import com.example.blogmanagement.model.request.AuthorRequest;

import java.util.List;


public interface AuthorService {
    List<Author> findAll();

    Author findById(int id);

    Author saveAuthor(AuthorRequest authorRequest);
}
