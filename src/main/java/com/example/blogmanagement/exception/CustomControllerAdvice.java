package com.example.blogmanagement.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CustomControllerAdvice {

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public ErrorResponse handleMyException(CustomException ex, HttpServletResponse response) {

        response.setStatus(ex.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(ex.getErrorCode());
        errorResponse.setMessage(ex.getErrorMsg());

        return errorResponse;
    }

}
