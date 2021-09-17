package com.colegio.matricula.service;

import com.colegio.matricula.bean.model.CursosModel;

import java.util.List;

public interface ICursoService {
    public List<CursosModel> list();
    public void add(CursosModel cursosModel);
    public void edith(CursosModel cursosModel);
    public void delete(int id);
    public CursosModel find(int id);
}
