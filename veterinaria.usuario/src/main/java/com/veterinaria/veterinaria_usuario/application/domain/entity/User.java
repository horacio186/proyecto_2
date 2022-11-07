package com.veterinaria.veterinaria_usuario.application.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class User {

    private int idUsuario;
    private String nombre;
    private String marcaEliminar;

    //private List<Mascota> mascotas;


}
