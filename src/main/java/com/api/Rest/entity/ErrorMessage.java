package com.api.Rest.entity;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
public class ErrorMessage {
    private HttpStatus status;
    private String message;
}
