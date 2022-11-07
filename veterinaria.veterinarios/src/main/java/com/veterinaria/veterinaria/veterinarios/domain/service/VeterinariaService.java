package com.veterinaria.veterinaria.veterinarios.domain.service;

import com.veterinaria.veterinaria.veterinarios.common.veterinaria.DuplicateVeterinariaException;
import com.veterinaria.veterinaria.veterinarios.common.veterinaria.InvalidVeterinariaException;
import com.veterinaria.veterinaria.veterinarios.common.veterinaria.VeterinariaNotFoundException;
import com.veterinaria.veterinaria.veterinarios.common.veterinaria.VeterinariaNotFoundException.*;
import com.veterinaria.veterinaria.veterinarios.common.veterinario.VeterinarioNotFoundException;
import com.veterinaria.veterinaria.veterinarios.domain.model.entity.Veterinario;
import com.veterinaria.veterinaria.veterinarios.domain.repository.VeterinarioRepository;
import com.veterinaria.veterinaria.veterinarios.domain.model.entity.Veterinaria;
import com.veterinaria.veterinaria.veterinarios.domain.repository.VeterinariaRepository;
import com.veterinaria.veterinaria.veterinarios.domain.repository.VeterinarioRepository;
import com.veterinaria.veterinaria.veterinarios.domain.valueobject.VeterinariaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VeterinariaService {

    @Autowired
    private VeterinariaRepository repository;

    @Autowired
    private VeterinarioRepository VeterinarioRepository;

    public List<Veterinaria> findAll() {
        return repository.findAll();
    }

    public Veterinaria findByRegistroNacional(String registro) {
        return repository.findByRegistroNacional(registro);
    }

    public void deleteVeterinaria(String registro) throws VeterinariaNotFoundException {
        Veterinaria veterinaria = repository.findByRegistroNacional(registro);

        if(veterinaria == null){
            throw new VeterinariaNotFoundException("Veterinaria no existe");

        }
        repository.delete(veterinaria);
    }

    public Veterinaria createVeterinaria(Veterinaria veterinaria) throws InvalidVeterinariaException, VeterinarioNotFoundException {

        Veterinario veterinario = VeterinarioRepository.findByNumeroLicencia(veterinaria.getRegistroNacional());
        Object[] args = {veterinaria};

        if(veterinario == null) {
            throw new VeterinarioNotFoundException("veterinary.not exist.message", args);
        }

        veterinaria.setVeterinario(veterinario);

        boolean existe = repository.existsByIdVeterinario(veterinaria.getRegistroNacional());

        if(existe) {
            throw new InvalidVeterinariaException("vet exist.message", args);
        }

        return repository.save(veterinaria);
    }

    public Veterinaria updateVeterinaria(String registro, VeterinariaVO vo) throws VeterinarioNotFoundException, VeterinariaNotFoundException{

        Veterinario veterinario = VeterinarioRepository.findByNumeroLicencia(vo.getNumeroLicencia());

        if(veterinario == null) {
            throw new VeterinarioNotFoundException("Veterinario no existe");
        }

        Veterinaria veterinaria = repository.findByRegistroNacional(registro);

        if(veterinaria == null){
            throw new VeterinariaNotFoundException("Vet no existe");
        }

        Veterinaria veterinaria1 = new Veterinaria();

        veterinaria1.setIdVeterinaria(veterinaria.getIdVeterinaria());
        veterinaria1.setRegistroNacional(veterinaria.getRegistroNacional());
        veterinaria1.setVeterinario(veterinario);
        veterinaria1.setEstaCertificado(vo.getEstaCertificado());
        veterinaria1.setNumeroLicencia(vo.getNumeroLicencia());

        return repository.save(veterinaria1);
    }

}
