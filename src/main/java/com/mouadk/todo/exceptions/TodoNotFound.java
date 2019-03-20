package com.mouadk.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TodoNotFound extends RuntimeException {
    public TodoNotFound(String message) {
        super(message);
    }
}
