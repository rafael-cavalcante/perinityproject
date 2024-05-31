package com.rafaelcavalcante.perinityproject.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotEqualException extends RuntimeException {
    public ResourceNotEqualException(String message) {super(message);}
}
