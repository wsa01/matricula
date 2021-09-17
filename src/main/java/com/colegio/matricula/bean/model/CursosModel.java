package com.colegio.matricula.bean.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "curso")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CursosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String name;
}
