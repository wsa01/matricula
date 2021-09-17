package com.colegio.matricula.service.impl;

import com.colegio.matricula.bean.model.AlumnosModel;
import com.colegio.matricula.converter.AlumnoReqToModel;
import com.colegio.matricula.enumeration.StatusEnum;
import com.colegio.matricula.exception.ServException;
import com.colegio.matricula.repository.AlumnoRepository;
import com.colegio.matricula.request.AlumnoReq;
import com.colegio.matricula.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class AlumnosServiceImpl implements IAlumnoService {

    @Autowired
    private AlumnoRepository repo;
    @Autowired
    private AlumnoReqToModel converter;

    @Override
    public List<AlumnosModel> list() {
        return repo.findAll();
    }

    @Override
    public void add(AlumnoReq alumnoReq) throws ServException {
        AlumnosModel alumnosModel=converter.convert(alumnoReq);
        List<AlumnosModel> alumnos= repo.findAll();
        //se valida el nombre completo(nombres y apellidos)
        boolean nameValid=alumnos.stream()
                .anyMatch(e->e.getNombre().equals(alumnosModel.getNombre()) &&
                        e.getApellido().equals(alumnosModel.getApellido()));
        if (nameValid){throw new ServException(StatusEnum.ERROR_ALUMNO_EXIST);}

        //se valida el correo electronico
        boolean emailValid= alumnos.stream()
                .map(AlumnosModel::getEmail)
                .anyMatch(l->l.equals(alumnosModel.getEmail()));
        if (emailValid){throw new ServException(StatusEnum.ERROR_EMAIL_EXIST);}

        repo.save(alumnosModel);
    }

    @Override
    public void edith(AlumnosModel alumnosModel) {
        repo.save(alumnosModel);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public AlumnosModel find(int id) {
        AlumnosModel result=repo.findById(id).orElse(null);
        return result;
    }
}
