package com.colegio.matricula.repository;

import com.colegio.matricula.bean.model.CursosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursosModel,Integer> {
}
