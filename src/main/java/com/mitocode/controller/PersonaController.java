package com.mitocode.controller;


import com.mitocode.exepcion.ModeloNotFoundException;
import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>>listar() throws Exception{
        List<Persona> lista=service.listar();
        return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) throws Exception{
        Persona obj = service.listarPorId(id);
        if (obj == null){
            throw new ModeloNotFoundException("ID NO ENCONRADO: "+id);
        }
        return new ResponseEntity<Persona>(obj,HttpStatus.OK);
    }

    //Registrar
    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody Persona persona) throws Exception{
        Persona obj= service.registrar(persona);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Modificar
    @PutMapping
    public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona persona) throws Exception{
        Persona obj= service.modificar(persona);
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);

    }

    //Borrar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        Persona obj = service.listarPorId(id);
        if (obj==null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
