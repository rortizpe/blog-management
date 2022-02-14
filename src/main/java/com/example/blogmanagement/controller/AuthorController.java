package com.example.blogmanagement.controller;

import com.example.blogmanagement.model.entity.Author;
import com.example.blogmanagement.model.request.AuthorRequest;
import com.example.blogmanagement.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("author")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @PostMapping
    public Author save(@RequestBody AuthorRequest authorRequest) {
        return authorService.saveAuthor(authorRequest);
    }
}
