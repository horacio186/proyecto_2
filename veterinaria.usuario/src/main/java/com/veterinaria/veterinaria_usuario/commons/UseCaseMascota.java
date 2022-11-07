package com.veterinaria.veterinaria_usuario.commons;

public interface UseCaseMascota<Input, Output> {
    Output execute(Input input);
}
