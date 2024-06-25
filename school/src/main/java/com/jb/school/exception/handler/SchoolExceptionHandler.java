package com.jb.school.exception.handler;

import com.jb.school.dto.ErrorResponse;
import com.jb.school.exception.SchoolNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SchoolExceptionHandler {

    @ResponseBody
    @ExceptionHandler(SchoolNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(SchoolNotFoundException e){
        return ErrorResponse.builder()
                .message(e.getMessage())
                .build();
    }
}
