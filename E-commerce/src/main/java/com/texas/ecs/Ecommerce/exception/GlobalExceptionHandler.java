package com.texas.ecs.Ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    protected ResponseEntity<Object> handleMethodArguementNotValid(MethodArgumentNotValidException e, HttpStatus headers
                                                                    , HttpStatusCode status, WebRequest request){
        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> fieldErrors = e.getFieldErrors();
        for(FieldError fieldError:fieldErrors){
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
        }
        return new ResponseEntity<>(
                errorMap, status
        );
    }
    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity handleUserNotFoundException(UserNotFoundException e) {
        Map<String, String> body = Map.of(
                "message", e.getMessage()
        );
        return new ResponseEntity(
                body, HttpStatus.NOT_FOUND
        );
    }

}

