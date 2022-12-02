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

import com.example.oficinamecanicajpa.domain.Modelo;
import com.example.oficinamecanicajpa.service.ModeloService;  

@RestController
@RequestMapping("/modelo")
public class ModeloController {
    
    @Autowired
    private ModeloService modeloService;
    
    private Modelo modelo;


    @GetMapping("/")
    public List<Modelo> obterTodosModelos() {
        return modeloService.findAll();
    }

    @GetMapping("/{id}")
    public Modelo obterModeloPorId(@PathVariable("id") Integer id) {
        return modeloService.findById(id);
    }

    @PostMapping(value = "/")
    public Modelo salvarModelo(@RequestBody Modelo modelo) {
        return modeloService.save(modelo);
    }

    @DeleteMapping(value = "/")
    public void deletarModeloPorId(Integer id) {
    	modeloService.deleteById(id);
    }

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
    
    
    
    
    
    
    
    
}
