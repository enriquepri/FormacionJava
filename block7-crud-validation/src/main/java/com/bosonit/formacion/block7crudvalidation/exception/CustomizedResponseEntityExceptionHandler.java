package com.bosonit.formacion.block7crudvalidation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<CustomError> entityNotFoundException (
            EntityNotFoundException ex){
        CustomError customError = new CustomError(new Date(), 404, ex.getMessage());
        return new ResponseEntity(customError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public final ResponseEntity<CustomError> unprocessableEntityException(
            UnprocessableEntityException ex){
        CustomError customError = new CustomError(new Date(), 422, ex.getMessage());
        return new ResponseEntity(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
