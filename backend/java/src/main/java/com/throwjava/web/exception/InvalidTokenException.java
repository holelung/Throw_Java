package com.throwjava.web.exception;

public class InvalidTokenException extends RuntimeException{
  public InvalidTokenException(String message) {
    super(message);
  }  
}
