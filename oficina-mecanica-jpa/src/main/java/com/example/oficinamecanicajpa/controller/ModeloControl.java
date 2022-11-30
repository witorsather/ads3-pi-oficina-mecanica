package com.example.oficinamecanicajpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinamecanicajpa.domain.Modelo;
import com.example.oficinamecanicajpa.repository.ModeloRepository;

@Component
@SessionScoped
public class ModeloControl {
	
	@Autowired
	private ModeloRepository modeloDao;
	
	private Modelo modelo = new Modelo();
	
	private List<Modelo> modelos = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		listar();
	}
	
	public void salvar() {
		modeloDao.save(modelo);
		modelo = new Modelo();
		listar();
	}
	
	public void listar() {
		modelos = modeloDao.findAll();
	}
	
	public void excluir(Integer id) {
		modeloDao.deleteById(id);
		listar();
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

}