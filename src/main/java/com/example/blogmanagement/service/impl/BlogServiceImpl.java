package com.example.blogmanagement.service.impl;

import com.example.blogmanagement.exception.CustomException;
import com.example.blogmanagement.exception.ErrorCategory;
import com.example.blogmanagement.model.entity.Author;
import com.example.blogmanagement.model.entity.Blog;
import com.example.blogmanagement.model.request.BlogRequest;
import com.example.blogmanagement.repository.BlogRepository;
import com.example.blogmanagement.service.AuthorService;
import com.example.blogmanagement.service.BlogService;
import com.example.blogmanagement.utils.StatusEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final AuthorService authorService;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findBlogById(int blogId) {
        return blogRepository.findById(blogId)
                .orElseThrow(() -> new CustomException(ErrorCategory.INTERNAL_ERROR.value(), "NO EXISTE BLOG"));
    }


    public int countAuthor(int authorId) {
        return blogRepository.countByAuthorId(authorId);
    }

    @Override
    public Blog saveBlog(BlogRequest blogRequest) {

        var date = authorService.findById(blogRequest.getAuthorId()).getBirthDate();

        Period period = Period.between(date, LocalDate.now());

        if (period.getYears() >= 18 &&
                countAuthor(blogRequest.getAuthorId()) <= 3) {

            var blog = Blog.builder()
                    .name(blogRequest.getName())
                    .url(blogRequest.getUrl())
                    .status(StatusEnum.ACTIVE.getCode())
                    .description(blogRequest.getDescription())
                    .author(Author.builder()
                            .id(blogRequest.getAuthorId())
                            .build())
                    .build();

            return blogRepository.save(blog);
        } else {
            throw new CustomException(ErrorCategory.INTERNAL_ERROR.value(), "AUTOR MENOR 18 AÑOS O CONTIENE 3 BLOG");
        }
    }


}
