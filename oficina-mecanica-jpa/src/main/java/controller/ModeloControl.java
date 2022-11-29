package controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.Marca;
import domain.Modelo;
import repository.ModeloRepository;

public class ModeloControl {
	
	private ModeloRepository ModeloRepository;
	
	private Modelo modelo = new Modelo();
	
	private List<Modelo> modelos = new ArrayList<>();
	
	public void init() {
		listar();
	}
	
	public void salvar() {
		ModeloRepository.save(modelo);
		modelo = new Modelo();
		listar();
	}
	
	public void listar() {
		modelos = ModeloRepository.findAll();
	}
	
	public void excluir(Integer id) {
		ModeloRepository.deleteById(id);
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