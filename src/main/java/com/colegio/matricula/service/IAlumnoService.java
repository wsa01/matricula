package com.colegio.matricula.service;

import com.colegio.matricula.bean.model.AlumnosModel;
import com.colegio.matricula.exception.ServException;
import com.colegio.matricula.request.AlumnoReq;

import java.util.List;

public interface IAlumnoService {
    public List<AlumnosModel> list() throws ServException;
    public void add(AlumnoReq alumnoReq)throws ServException;
    public void edith(AlumnosModel alumnosModel)throws ServException;
    public void delete(int id)throws ServException;
    public AlumnosModel find(int id)throws ServException;
}
