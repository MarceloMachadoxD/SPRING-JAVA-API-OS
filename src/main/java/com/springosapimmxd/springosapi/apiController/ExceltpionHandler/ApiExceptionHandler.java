package com.springosapimmxd.springosapi.apiController.ExceltpionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       Problema problema = new Problema(status.value(), LocalDateTime.now(),"Um ou mais campos inválidos ou obrigatórios sem dados");
        return super.handleExceptionInternal(ex,problema,headers,status,request);
    }
}
