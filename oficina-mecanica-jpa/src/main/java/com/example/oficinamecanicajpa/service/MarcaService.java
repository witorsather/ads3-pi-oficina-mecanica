package com.example.oficinamecanicajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oficinamecanicajpa.domain.Marca;
import com.example.oficinamecanicajpa.repository.MarcaRepository;

@Service
public class MarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> findAll() {
        return this.marcaRepository.findAll();
    }

    public Marca findById(Integer id) {
        return this.marcaRepository.findById(id).get();
    }

    public Marca save(Marca marca) {
        return this.marcaRepository.save(marca);
    }

    public void deleteById(Integer id) {
        this.marcaRepository.deleteById(id);
    }
}
