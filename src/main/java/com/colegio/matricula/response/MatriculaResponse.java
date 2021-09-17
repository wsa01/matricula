package com.colegio.matricula.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MatriculaResponse <T>{
    private StatusResponse status;
    private T data;

    public MatriculaResponse(StatusResponse status) {
        this.status = status;
    }
}
