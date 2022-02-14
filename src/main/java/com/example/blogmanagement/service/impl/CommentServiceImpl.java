package com.example.blogmanagement.service.impl;

import com.example.blogmanagement.exception.CustomException;
import com.example.blogmanagement.exception.ErrorCategory;
import com.example.blogmanagement.model.entity.Comment;
import com.example.blogmanagement.model.entity.Post;
import com.example.blogmanagement.model.request.CommentRequest;
import com.example.blogmanagement.repository.CommentRepository;
import com.example.blogmanagement.service.CommentService;
import com.example.blogmanagement.service.PostService;
import com.example.blogmanagement.utils.StatusEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment registerComment(CommentRequest commentRequest) {

        var postStatus = postService.findPostById(commentRequest.getPost()).getStatus();

        if (postStatus.equalsIgnoreCase(StatusEnum.RELEASED.getCode())) {
            var comment = Comment.builder()
                    .date(LocalDateTime.now())
                    .name(commentRequest.getName())
                    .status(StatusEnum.RELEASED.getCode())
                    .post(Post.builder()
                            .id(commentRequest.getPost())
                            .build())
                    .build();

            return commentRepository.save(comment);
        } else {
            throw new CustomException(ErrorCategory.INTERNAL_ERROR.value(), "EL POST NO ESTA ACTIVO");
        }

    }
}
