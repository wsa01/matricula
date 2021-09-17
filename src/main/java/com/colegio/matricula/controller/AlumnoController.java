package com.colegio.matricula.controller;

import com.colegio.matricula.bean.model.AlumnosModel;
import com.colegio.matricula.converter.AlumnoReqToModel;
import com.colegio.matricula.enumeration.StatusEnum;
import com.colegio.matricula.exception.InvalidDataException;
import com.colegio.matricula.exception.ServException;
import com.colegio.matricula.request.AlumnoReq;
import com.colegio.matricula.response.MatriculaResponse;
import com.colegio.matricula.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    private IAlumnoService service;

    @GetMapping
    public ResponseEntity<?> listA() throws ServException {
        List<AlumnosModel> result=service.list();
        return ResponseEntity.ok().body(new MatriculaResponse<>(StatusEnum.OK.getStatus(),result));
    }

    @PostMapping
    public ResponseEntity<?> addA(@Valid @RequestBody AlumnoReq alumnoReq, BindingResult result) throws ServException, InvalidDataException {
        if (result.hasErrors()){throw new InvalidDataException(result);}
        service.add(alumnoReq);
        return ResponseEntity.ok().build();
    }

}
