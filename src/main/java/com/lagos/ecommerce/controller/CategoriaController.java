package com.lagos.ecommerce.controller;

import com.lagos.ecommerce.domain.categorias.Categoria;
import com.lagos.ecommerce.domain.categorias.CategoriaRepository;
import com.lagos.ecommerce.domain.categorias.DatosCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> obtenerCategorias(){
        return categoriaRepository.findAll();
    }

    @PostMapping
    public void crearCategoria(@RequestBody DatosCategoria datosCategoria){
        Categoria categoria = new Categoria(null, datosCategoria.nombre(), datosCategoria.descripcion(), null);
        categoriaRepository.save(categoria);
    }
}
