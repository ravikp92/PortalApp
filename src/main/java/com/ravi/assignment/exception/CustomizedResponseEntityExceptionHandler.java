package com.ravi.assignment.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler({Exception.class})
  public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
    APIError error = new APIError(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  @ExceptionHandler({PatientNotFoundException.class})
  public final ResponseEntity<Object> handleAllUserNotFoundException(PatientNotFoundException ex, WebRequest request) throws Exception {
    APIError error = new APIError(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
  }
  
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    APIError error = new APIError(LocalDateTime.now(), "Validation Failed", ex.getBindingResult().toString());
    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
  }
}
