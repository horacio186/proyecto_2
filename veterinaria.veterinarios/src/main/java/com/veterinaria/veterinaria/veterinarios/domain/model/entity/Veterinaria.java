package com.veterinaria.veterinaria.veterinarios.domain.model.entity;

import com.veterinaria.veterinaria.veterinarios.domain.model.entity.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("veterinaria")
public class Veterinaria  {

    @Id
    private String idVeterinaria;
    private String registroNacional;
    private String estaCertificado;

    private String numeroLicencia;


    private String idVeterinario;

    @DBRef
    Veterinario veterinario;

    public Veterinaria() {
        super();
    }


    public String getRegistroNacional() {
        return registroNacional;
    }

    public void setRegistroNacional(String registroNacional) {
        this.registroNacional = registroNacional;
    }

    public String getEstaCertificado() {
        return estaCertificado;
    }

    public void setEstaCertificado(String estaCertificado) {
        this.estaCertificado = estaCertificado;
    }

    public String getIdVeterinaria() {
        return idVeterinaria;
    }

    public void setIdVeterinaria(String idVeterinaria) {
        this.idVeterinaria = idVeterinaria;
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }


    public void setVeterinario(Veterinario veterinario) {
    }

    public void setNumeroLicencia(String numeroLicencia) {
    }
}
