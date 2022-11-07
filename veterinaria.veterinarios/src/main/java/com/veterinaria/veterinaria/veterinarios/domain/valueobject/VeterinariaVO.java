package com.veterinaria.veterinaria.veterinarios.domain.valueobject;

import com.veterinaria.veterinaria.veterinarios.domain.model.entity.Veterinario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeterinariaVO {


    private String idVeterinaria;

    private String registroNacional;
    private String estaCertificado;
    private String numeroLicencia;
    private Veterinario veterinario;




}
