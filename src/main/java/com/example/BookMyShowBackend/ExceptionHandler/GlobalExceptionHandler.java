package com.example.BookMyShowBackend.ExceptionHandler;

import com.example.BookMyShowBackend.Exceptions.UserLockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = UserLockedException.class)
    public String UserLockedExceptionHandler(UserLockedException e){
        return e.getMessage();
    }
}
