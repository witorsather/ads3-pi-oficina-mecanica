package com.example.oficinaco.jpa.jsf;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.oficinaco.jpa.dao.ModeloDao;
import com.example.oficinaco.jpa.dao.VeiculoDao;
import com.example.oficinaco.jpa.entidade.Modelo;
import com.example.oficinaco.jpa.entidade.Servico;
import com.example.oficinaco.jpa.entidade.Veiculo;

@Component
@SessionScope
public class VeiculoControl {

@Autowired
private VeiculoDao veiculoDao;

private Veiculo veiculo = new Veiculo();

private Integer modeloId;

@Autowired
private ModeloDao modeloDao;

private List<Veiculo> veiculos = new ArrayList<>();

private List<Veiculo> veiculosFiltro = new ArrayList<>();

@PostConstruct
	public void init() {
		listar();
	}

	public void selecionarModelo(){
		Modelo modelo = modeloDao.findById(modeloId).get();
		veiculo.setModelo(modelo);
	}

	public List<Modelo>completeModelo(String query) {
    	return modeloDao.listarPorNome("%" + query + "%");
    }	

	public void salvar() {
		veiculoDao.save(veiculo);
		veiculo = new Veiculo();
		listar();
	}
	
	public void listar() {
		veiculos = veiculoDao.findAll();
	}
	
	public void excluir(Integer id) {
		veiculoDao.deleteById(id);
		listar();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Integer getModeloId() {
		return modeloId;
	}

	public void setModeloId(Integer modeloId) {
		this.modeloId = modeloId;
	}

	public ModeloDao getModeloDao() {
		return modeloDao;
	}

	public void setModeloDao(ModeloDao modeloDao) {
		this.modeloDao = modeloDao;
	}

	public List<Veiculo> getVeiculosFiltro() {
		return veiculosFiltro;
	}

	public void setVeiculosFiltro(List<Veiculo> veiculosFiltro) {
		this.veiculosFiltro = veiculosFiltro;
	}
}