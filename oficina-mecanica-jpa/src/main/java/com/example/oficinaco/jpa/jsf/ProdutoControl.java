package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import com.example.oficinaco.jpa.dao.ProdutoDao;
import com.example.oficinaco.jpa.entidade.Produto;

@Component
@SessionScope
public class ProdutoControl {

@Autowired
private ProdutoDao produtoDao;

private Produto produto = new Produto();

private List<Produto> produtos = new ArrayList<>();

private List<Produto> produtosFiltro = new ArrayList<>();

	@PostConstruct
	public void init() {
		listar();
	}
	
	public void salvar() {
		produtoDao.save(produto);
		produto = new Produto();
		listar();
	}
	
	public void listar(){
	    produtos = produtoDao.findAll();
	}
	
	public void excluir(Integer id) {
		produtoDao.deleteById(id);
		listar();
	}
	
	public Produto getProduto() {
	    return produto;
	}
	
	public void setProduto(Produto produto) {
	    this.produto = produto;
	}
	
	public List<Produto> getProdutos() {
	    return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
	    this.produtos = produtos;
	}
	
	public List<Produto> getProdutosFiltro() {
		return produtosFiltro;
	}
	
	public void setProdutosFiltro(List<Produto> produtosFiltro) {
		this.produtosFiltro = produtosFiltro;
	}
}
