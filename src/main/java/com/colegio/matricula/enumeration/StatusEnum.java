package com.colegio.matricula.enumeration;

import com.colegio.matricula.response.StatusResponse;
import lombok.Getter;

@Getter
public enum StatusEnum {
    OK("8001","proceso exitoso"),
    ERROR_ALUMNO_EXIST("9002","el alumno ya se encuentra registrado"),
    ERROR_ALUMNO_NOT_EXIST("9003","el alumno no se encuentra registrado"),
    ERROR_EMAIL_EXIST("9004","el correo ya se encuentra registrado"),
    ERROR_INVALID_DATA("9006","los datos son invalidos")
    ;

    private StatusResponse status;

    StatusEnum(String code, String message) {
        this.status = StatusResponse.builder().code(code).message(message).build();
    }
}
