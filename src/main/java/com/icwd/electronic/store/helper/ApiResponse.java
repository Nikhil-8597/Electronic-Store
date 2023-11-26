package com.icwd.electronic.store.helper;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiResponse {


    private String message;
    private HttpStatus status;
    private boolean success;
}
