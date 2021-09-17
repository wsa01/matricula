package com.colegio.matricula.exception;

import com.colegio.matricula.enumeration.StatusEnum;
import com.colegio.matricula.response.StatusResponse;
import lombok.Getter;

@Getter
public class ServException extends Exception{

    private final StatusResponse statusResponse;

    public ServException(StatusEnum status) {
        this.statusResponse = status.getStatus();
    }
}
