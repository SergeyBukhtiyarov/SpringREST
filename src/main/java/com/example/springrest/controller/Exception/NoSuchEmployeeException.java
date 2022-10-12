package com.example.springrest.controller.Exception;

import lombok.Data;


public class NoSuchEmployeeException extends RuntimeException{
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
