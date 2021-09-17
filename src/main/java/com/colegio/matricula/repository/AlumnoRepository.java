package com.colegio.matricula.repository;

import com.colegio.matricula.bean.model.AlumnosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnosModel,Integer>{
}
