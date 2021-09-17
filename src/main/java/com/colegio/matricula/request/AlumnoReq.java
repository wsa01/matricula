package com.colegio.matricula.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoReq {
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;
    @NotEmpty(message = "El apellido no puede estar vacio")
    private String apellido;
    @NotEmpty(message = "El correo no puede estar vacio")
    private String email;
}
