package com.example.oficinamecanicajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oficinamecanicajpa.domain.Marca;
import com.example.oficinamecanicajpa.domain.Modelo;
import com.example.oficinamecanicajpa.repository.MarcaRepository;
import com.example.oficinamecanicajpa.repository.ModeloRepository;

@Service
public class ModeloService {
    
    @Autowired
    private ModeloRepository modeloRepository;
    

    
    public List<Modelo> findAll() {
        return this.modeloRepository.findAll();
    }

    public Modelo findById(Integer id) {
        return this.modeloRepository.findById(id).get();
    }

    public Modelo save(Modelo modelo) {
        return this.modeloRepository.save(modelo);
    }

    public void deleteById(Integer id) {
        this.modeloRepository.deleteById(id);
    }
    
    
}
