package com.batrawy.ais.exception;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AisExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ExceptionPayload payload =
                new ExceptionPayload(e.getMessage(), httpStatus);
        return new ResponseEntity<>(payload, httpStatus);
    }

    @ExceptionHandler(value = {ParseException.class})
    public ResponseEntity<Object> handleParseException(ParseException e) {
        HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;
        ExceptionPayload payload =
                new ExceptionPayload(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(payload, httpStatus);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<Object> handleConstraintValidationException(ConstraintViolationException constraintViolationException) {
        Map<String, String> response = new HashMap<>();
        for (ConstraintViolation violation : constraintViolationException.getConstraintViolations()) {
            response.put(((PathImpl) violation.getPropertyPath()).getLeafNode().getName(), violation.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Object> handleConstraintValidationException(MethodArgumentNotValidException e) {
        Map<String, String> response = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            response.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    ResponseEntity<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return new ResponseEntity<>(e.getParameterName(), HttpStatus.BAD_REQUEST);
    }


}
