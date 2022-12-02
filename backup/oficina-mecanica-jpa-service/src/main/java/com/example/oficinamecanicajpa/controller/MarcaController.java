package com.example.oficinamecanicajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oficinamecanicajpa.domain.Marca;
import com.example.oficinamecanicajpa.service.MarcaService;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
    
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> obterTodosMarcas() {
        return marcaService.findAll();
    }

    @GetMapping("/{id}")
    public Marca obterMarcaPorId(@PathVariable("id") Integer id) {
        return marcaService.findById(id);
    }

    @PostMapping(value = "/")
    public Marca salvarMarca(@RequestBody Marca Marca) {
        return marcaService.save(Marca);
    }

    @DeleteMapping(value = "/")
    public void deletarMarcaPorId(Integer id) {
        marcaService.deleteById(id);
    }
}
