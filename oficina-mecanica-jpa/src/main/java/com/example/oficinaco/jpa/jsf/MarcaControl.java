package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.MarcaDao;
import com.example.oficinaco.jpa.entidade.Marca;

@Component
@SessionScoped
public class MarcaControl {
	
	@Autowired
	private MarcaDao marcaDao;
	
	private Marca marca = new Marca();
	
	private List<Marca> marcas = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		listar();
	}
	
	public void salvar() {
		marcaDao.save(marca);
		marca = new Marca();
		listar();
	}
	
	public void listar() {
		marcas = marcaDao.findAll();
	}
	
	public void excluir(Integer id) {
		marcaDao.deleteById(id);
		listar();
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}
	
	
	
}














