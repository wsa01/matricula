package com.colegio.matricula.converter;

import com.colegio.matricula.bean.model.AlumnosModel;
import com.colegio.matricula.request.AlumnoReq;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AlumnoReqToModel implements Converter<AlumnoReq,AlumnosModel> {

    @Override
    public AlumnosModel convert(AlumnoReq source) {
        AlumnosModel alumnosModel=new AlumnosModel();
        BeanUtils.copyProperties(source,alumnosModel,"tyDoc");
        return alumnosModel;
    }
}
