package com.ravi.assignment.exception;

import java.time.LocalDateTime;

public class APIError {
  private LocalDateTime timestamp;
  
  private String message;
  
  private String details;
  
  public APIError(LocalDateTime timestamp, String message, String details) {
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
  }
  
  public LocalDateTime getTimestamp() {
    return this.timestamp;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getDetails() {
    return this.details;
  }
}
