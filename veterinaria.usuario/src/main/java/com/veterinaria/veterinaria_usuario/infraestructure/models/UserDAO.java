package com.veterinaria.veterinaria_usuario.infraestructure.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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
