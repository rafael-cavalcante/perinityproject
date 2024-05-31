package com.rafaelcavalcante.perinityproject.config.exception.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;
}
