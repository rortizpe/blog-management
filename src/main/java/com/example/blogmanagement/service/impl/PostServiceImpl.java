package com.example.blogmanagement.service.impl;

import com.example.blogmanagement.exception.CustomException;
import com.example.blogmanagement.exception.ErrorCategory;
import com.example.blogmanagement.model.entity.Blog;
import com.example.blogmanagement.model.entity.Post;
import com.example.blogmanagement.model.request.PostRequest;
import com.example.blogmanagement.repository.PostRepository;
import com.example.blogmanagement.service.BlogService;
import com.example.blogmanagement.service.PostService;
import com.example.blogmanagement.utils.StatusEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final BlogService blogService;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findPostById(int id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCategory.INTERNAL_ERROR.value(), "NO EXISTE POST"));
    }

    @Override
    public Post savePost(PostRequest postRequest) {

        var statusBlog = blogService.findBlogById(postRequest.getBlogId()).getStatus();
        var valid = postRepository.existsByBlogIdAndStatusAndDateEquals(postRequest.getBlogId(),
                StatusEnum.ACTIVE.getCode(), LocalDate.now());

        if (statusBlog.equalsIgnoreCase(StatusEnum.ACTIVE.getCode())) {
            var post = Post.builder()
                    .tittle(postRequest.getTittle())
                    .date(LocalDate.now())
                    .content(postRequest.getContent())
                    .status(valid ? StatusEnum.RELEASED.getCode() : StatusEnum.DRAFT.getCode())
                    .blog(Blog.builder()
                            .id(postRequest.getBlogId())
                            .build())
                    .build();
            return postRepository.save(post);
        } else {

            throw new CustomException(ErrorCategory.INTERNAL_ERROR.value(), "BLOG INACTIVO");
        }


    }


}
