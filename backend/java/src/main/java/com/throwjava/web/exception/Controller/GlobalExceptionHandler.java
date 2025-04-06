package com.throwjava.web.exception.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.throwjava.web.exception.AlreadySaveQuestionException;
import com.throwjava.web.exception.ContentNullPointerException;
import com.throwjava.web.exception.CustomAuthenticationException;
import com.throwjava.web.exception.InvalidPasswordException;
import com.throwjava.web.exception.InvalidTokenException;
import com.throwjava.web.exception.MemberIdDuplicationException;
import com.throwjava.web.exception.UnauthorizedAccessException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private ResponseEntity<Map<String, String>> makeResponseEntity(RuntimeException e, HttpStatus status) {
        Map<String, String> error = new HashMap<>();
        error.put("error-message", e.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(AlreadySaveQuestionException.class)
    public ResponseEntity<Map<String, String>> handleAlreadySaveError(AlreadySaveQuestionException e) {
        return makeResponseEntity(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ContentNullPointerException.class)
    public ResponseEntity<Map<String, String>> handleContentNullError(ContentNullPointerException e) {
        return makeResponseEntity(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)    
    public ResponseEntity<Map<String, String>> handleUnauthorizedError(UnauthorizedAccessException e) {
        return makeResponseEntity(e, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Map<String, String>> handleInvalidPasswordError(InvalidPasswordException e) {
        return makeResponseEntity(e, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CustomAuthenticationException.class)
    public ResponseEntity<Map<String, String>> handleCustomAuthenticationError(CustomAuthenticationException e) {
        return makeResponseEntity(e, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Map<String, String>> handleInvalidTokenError(InvalidTokenException e) {
        return makeResponseEntity(e, HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(MemberIdDuplicationException.class)
    public ResponseEntity<Map<String, String>> handleMemberIdDuplicationError(MemberIdDuplicationException e) {
        return makeResponseEntity(e, HttpStatus.CONFLICT);
    }
}
