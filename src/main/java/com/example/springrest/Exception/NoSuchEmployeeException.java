package com.example.springrest.Exception;

import lombok.Data;


public class NoSuchEmployeeException extends RuntimeException{
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
