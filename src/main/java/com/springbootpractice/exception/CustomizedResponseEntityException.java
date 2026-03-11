package com.springbootpractice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;

@RestControllerAdvice
public class CustomizedResponseEntityException {


    // 1. Catch ANY exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                LocalDate.now(),
                request.getDescription(false),
                "500 Internal Server Error"
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 2. Handle Runtime Exceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntime(RuntimeException ex, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                LocalDate.now(),
                request.getDescription(false),
                "Runtime Exception"
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 3. Handle Custom Exceptions
    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<Object> handleInvalidEntityException(InvalidEntityException ex, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                LocalDate.now(),
                request.getDescription(false),
                "400 Bad Request"
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // 4. Handle Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(
                ex.getBindingResult().getFieldError().getDefaultMessage(),
                LocalDate.now(),
                request.getDescription(false),
                "Validation Failed"
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDenied(AccessDeniedException ex, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(
                "Access Denied",
                LocalDate.now(),
                request.getDescription(false),
                "403 Forbidden"
        );

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    // 5. Handle JSON Parsing Errors
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<Object> handleInvalidJson(HttpMessageNotReadableException ex, WebRequest request) {
//
//        ExceptionResponse response = new ExceptionResponse(
//                "Invalid JSON Format",
//                LocalDate.now(),
//                request.getDescription(false),
//                "400 Bad Request"
//        );
//
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

    // 6. Handle Database Errors
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<Object> handleDatabaseErrors(DataIntegrityViolationException ex, WebRequest request) {
//
//        ExceptionResponse response = new ExceptionResponse(
//                "Database Constraint Violation",
//                LocalDate.now(),
//                request.getDescription(false),
//                "Database Error"
//        );
//
//        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
//    }

    // 7. Handle Security Errors


    // 8. Handle JWT Exceptions
//    @ExceptionHandler(JwtException.class)
//    public ResponseEntity<Object> handleJwtError(JwtException ex, WebRequest request) {
//
//        ExceptionResponse response = new ExceptionResponse(
//                ex.getMessage(),
//                LocalDate.now(),
//                request.getDescription(false),
//                "Invalid Token"
//        );
//
//        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
//    }
}
