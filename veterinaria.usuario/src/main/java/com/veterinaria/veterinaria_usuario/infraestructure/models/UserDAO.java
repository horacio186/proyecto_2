package com.veterinaria.veterinaria_usuario.infraestructure.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Getter
@Setter
@ToString
@Entity
@Table(name = "usuario")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(length = 50)
    private String nombre;

    @Column(name = "marca_eliminar", length = 1)
    private String marcaEliminar;

    @OneToMany(mappedBy = "user")
    private List<MascotaDAO> mascotas;


}
