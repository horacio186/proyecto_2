package com.veterinaria.veterinaria.veterinarios.resources;

import com.veterinaria.veterinaria.veterinarios.common.veterinaria.VeterinariaNotFoundException;
import com.veterinaria.veterinaria.veterinarios.common.veterinario.VeterinarioNotFoundException;
import com.veterinaria.veterinaria.veterinarios.domain.model.entity.Veterinario;
import com.veterinaria.veterinaria.veterinarios.domain.service.VeterinarioService;
import com.veterinaria.veterinaria.veterinarios.domain.valueobject.VeterinarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private VeterinarioService service;

    @PostMapping("/save")
    public ResponseEntity<Veterinario> add(@RequestBody Veterinario veterinario) throws VeterinarioNotFoundException {
        Veterinario vet = service.createVeterinario(veterinario);
        return new ResponseEntity<>(vet, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Veterinario>> listarVeterinarios() {
        List<Veterinario> veterinarios = service.findAll();
        return new ResponseEntity<>(veterinarios, HttpStatus.OK);
    }

    @GetMapping("/{licencia}")
    public ResponseEntity<Veterinario> obtenerVeterinario(@PathVariable String licencia) {
        Veterinario veterinario = service.findByNumeroLicencia(licencia);
        return new ResponseEntity<>(veterinario, HttpStatus.OK);
    }

    @PutMapping("/update/{licencia}")
    public ResponseEntity<Veterinario> updateVeterinario(@PathVariable String licencia, @RequestBody VeterinarioVO vo) throws VeterinariaNotFoundException, VeterinarioNotFoundException {
        Veterinario veterinario = service.update(licencia, vo);
        return new ResponseEntity<>(veterinario, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{licencia}")
    public ResponseEntity<Object> deleteVeterinario(@PathVariable String licencia) throws VeterinarioNotFoundException {
        service.deleteVeterinario(licencia);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
