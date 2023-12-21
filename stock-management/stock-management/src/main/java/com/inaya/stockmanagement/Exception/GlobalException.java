package com.inaya.stockmanagement.Exception;

import com.inaya.stockmanagement.dto.BaseResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponseDTO> handleBaseException(BaseException e) {
        BaseResponseDTO response = BaseResponseDTO.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.PRECONDITION_FAILED);
    }

}