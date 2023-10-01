package com.openpay.donation.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<?,?>> handleValidationException(
            MethodArgumentNotValidException ex) {
                List<Map<?,?>> errors = new ArrayList<Map<?,?>>();
                ex.getBindingResult().getAllErrors().forEach((error) -> {
                    Map<String, Object> errorDescription = new HashMap<String, Object>();
                    errorDescription.put("field", error.getObjectName());
                    errorDescription.put("message", error.getDefaultMessage());
                    errors.add(errorDescription);
                }); 
                Map<String, Object> errorsMap = new HashMap<String,Object>();
                errorsMap.put("errors", errors);
                return ResponseEntity.badRequest().body(errorsMap);
    }

    @ExceptionHandler(Exception.class) 
    public ResponseEntity<Object> handleRuntimeException(Exception ex) {
        Map<String,Object> error = new HashMap<String, Object>();
        error.put("error", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
