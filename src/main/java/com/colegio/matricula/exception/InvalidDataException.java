package com.colegio.matricula.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.validation.BindingResult;



public class InvalidDataException extends Exception{

    private final BindingResult result;

    public InvalidDataException(BindingResult result) {
        super();
        this.result = result;
    }

    public BindingResult getResult(){
        return result;
    }

}
