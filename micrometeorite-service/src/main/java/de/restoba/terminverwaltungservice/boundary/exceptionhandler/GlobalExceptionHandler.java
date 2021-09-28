package de.restoba.terminverwaltungservice.boundary.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public void globalException(Exception e){
        System.err.println(e.fillInStackTrace());
        System.err.println(e.getMessage());
        System.err.println(e.getStackTrace().toString());
        System.err.println(e.getCause());
    }
}
