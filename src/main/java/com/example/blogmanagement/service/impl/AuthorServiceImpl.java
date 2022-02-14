package com.example.blogmanagement.service.impl;

import com.example.blogmanagement.exception.CustomException;
import com.example.blogmanagement.exception.ErrorCategory;
import com.example.blogmanagement.model.entity.Author;
import com.example.blogmanagement.model.request.AuthorRequest;
import com.example.blogmanagement.repository.AuthorRepository;
import com.example.blogmanagement.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public static LocalDate parseToDate(String dateString) {
        var dateFormat = "dd/MM/yyyy";
        if (dateString == null) {
            return null;
        }
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern(dateFormat);
        return LocalDate.parse(dateString, formatter);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(int id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCategory.INTERNAL_ERROR.value(), "NO EXISTE AUTHOR"));
    }

    @Override
    public Author saveAuthor(AuthorRequest authorRequest) {
        var author = Author.builder()
                .name(authorRequest.getName())
                .email(authorRequest.getEmail())
                .phone(authorRequest.getPhone())
                .birthDate(parseToDate(authorRequest.getBirthDate()))
                .build();
        return authorRepository.save(author);
    }
}
