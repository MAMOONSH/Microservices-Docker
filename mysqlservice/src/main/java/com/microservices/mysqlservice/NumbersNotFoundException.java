package com.microservices.mysqlservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NumbersNotFoundException extends RuntimeException{
    public NumbersNotFoundException(String message) {
        super(message);
    }
}
