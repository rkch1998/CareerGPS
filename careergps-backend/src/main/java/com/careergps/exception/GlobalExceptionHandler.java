package com.careergps.exception;

import jakarta.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.LinkedHashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(EntityNotFoundException.class)
  ResponseEntity<ApiError> notFound(EntityNotFoundException ex) {
    return error(HttpStatus.NOT_FOUND, ex.getMessage(), new LinkedHashMap<>());
  }

  @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
  ResponseEntity<ApiError> badRequest(RuntimeException ex) {
    return error(HttpStatus.BAD_REQUEST, ex.getMessage(), new LinkedHashMap<>());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  ResponseEntity<ApiError> validation(MethodArgumentNotValidException ex) {
    var fields = new LinkedHashMap<String, String>();
    ex.getBindingResult()
        .getFieldErrors()
        .forEach(error -> fields.put(error.getField(), error.getDefaultMessage()));
    return error(HttpStatus.BAD_REQUEST, "Request validation failed", fields);
  }

  private ResponseEntity<ApiError> error(
      HttpStatus status, String message, java.util.Map<String, String> fields) {
    return ResponseEntity.status(status)
        .body(new ApiError(Instant.now(), status.value(), message, fields));
  }
}
