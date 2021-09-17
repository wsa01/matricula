package com.colegio.matricula.advice;

import com.colegio.matricula.enumeration.StatusEnum;
import com.colegio.matricula.exception.InvalidDataException;
import com.colegio.matricula.exception.ServException;
import com.colegio.matricula.response.MatriculaResponse;
import com.colegio.matricula.response.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class MatriculaAdvice {

    @ExceptionHandler
    public ResponseEntity<?> ServException(ServException e){
        return ResponseEntity.badRequest().body(e.getStatusResponse());
    }
    @ExceptionHandler
    public ResponseEntity<?> InvalidData(InvalidDataException e){
        StatusResponse result=StatusEnum.ERROR_INVALID_DATA.getStatus();
        List<String> errors=e.getResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        result.setErrors(errors);
        return ResponseEntity.badRequest().body(result);
    }

}
