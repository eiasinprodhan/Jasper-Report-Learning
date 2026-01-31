package com.springboot.practice.exeption;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
