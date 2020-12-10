package com.mitocode.controller;


import com.mitocode.exepcion.ModeloNotFoundException;
import com.mitocode.model.Producto;
import com.mitocode.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() throws Exception{
        List<Producto> lista=service.listar();
        return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) throws Exception{
        Producto obj = service.listarPorId(id);
        if (obj == null){
            throw new ModeloNotFoundException("ID NO ENCONRADO: "+id);
        }
        return new ResponseEntity<Producto>(obj,HttpStatus.OK);
    }

    //Registrar
    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody Producto producto) throws Exception{
        Producto obj= service.registrar(producto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProducto()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Modificar
    @PutMapping
    public ResponseEntity<Producto> modificar(@Valid @RequestBody Producto producto) throws Exception{
        Producto obj= service.modificar(producto);
        return new ResponseEntity<Producto>(obj, HttpStatus.OK);

    }

    //Borrar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        Producto obj = service.listarPorId(id);
        if (obj==null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
