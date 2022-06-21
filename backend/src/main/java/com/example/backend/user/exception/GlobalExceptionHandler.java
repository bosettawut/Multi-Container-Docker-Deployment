package com.example.backend.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException
            (ResourceNotFoundException exception, WebRequest request){
        ErrorDetail errorDetail = new ErrorDetail(exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorDetail handleResourceNotFound(final Exception exception) {
        ErrorDetail error = new ErrorDetail();
        error.setError("error message");
        return error;
    }
}
