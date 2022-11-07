package com.veterinaria.veterinaria.veterinarios.domain.service;

import com.veterinaria.veterinaria.veterinarios.common.veterinaria.VeterinariaNotFoundException;
import com.veterinaria.veterinaria.veterinarios.common.veterinario.VeterinarioNotFoundException;
import com.veterinaria.veterinaria.veterinarios.domain.model.entity.Veterinaria;
import com.veterinaria.veterinaria.veterinarios.domain.model.entity.Veterinario;
import com.veterinaria.veterinaria.veterinarios.domain.repository.VeterinarioRepository;
import com.veterinaria.veterinaria.veterinarios.domain.valueobject.VeterinarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository repository;

    public List<Veterinario> findAll() {
        return repository.findAll();
    }

    public Veterinario findByNumeroLicencia(String licencia) {
        return repository.findByNumeroLicencia(licencia);
    }

    public void deleteVeterinario(String registro) throws VeterinarioNotFoundException {
        Veterinario veterinario = repository.findByNumeroLicencia(registro);

        if(veterinario == null){
            throw new VeterinarioNotFoundException("Veterinario no existe");

        }
        repository.delete(veterinario);
    }

    public Veterinario update(String licencia, VeterinarioVO vo) throws VeterinarioNotFoundException, VeterinariaNotFoundException{

        Veterinario veterinario = repository.findByNumeroLicencia(licencia);

        if(veterinario == null){
            throw new VeterinarioNotFoundException("Veterinario no existe");
        }

        Veterinario veterinario1 = new Veterinario();

        veterinario1.setIdVeterinario(veterinario.getIdVeterinario());
        veterinario1.setNumeroLicencia(veterinario.getNumeroLicencia());
        veterinario1.setNombre(vo.getNombre());

        return repository.save(veterinario1);
    }

    public Veterinario createVeterinario(Veterinario veterinario) throws VeterinarioNotFoundException{

        boolean existe = repository.existsVeterinarioByNumeroLicencia(veterinario.getNumeroLicencia());

        if(existe) {
            throw new VeterinarioNotFoundException("Usuario con licencia profesional existe");
        }

        return repository.save(veterinario);
    }

}
