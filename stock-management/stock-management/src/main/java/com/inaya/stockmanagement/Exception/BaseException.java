package com.inaya.stockmanagement.Exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseException extends RuntimeException {

    private String message;
    public BaseException(String message) {
        this.message = message;
    }
}