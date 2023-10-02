package com.example.BookMyShowBackend.Exceptions;

public class UserLockedException extends RuntimeException{

    private String message;

    public UserLockedException(String message){
        super(message);
    }
}
