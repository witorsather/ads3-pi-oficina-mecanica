package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.oficinaco.jpa.dao.PessoaDao;
import com.example.oficinaco.jpa.entidade.Pessoa;

@Component
@SessionScope
public class PessoaControl {

@Autowired
private PessoaDao pessoaDao;

private Pessoa pessoa = new Pessoa();

private List<Pessoa> pessoas = new ArrayList<>();


@PostConstruct
	public void init() {
		listar();
	}
	
	public void salvar() {
		pessoaDao.save(pessoa);
		pessoa = new Pessoa();
		listar();
	}
	
	public void listar() {
		pessoas = pessoaDao.findAll();
	}
	
	public void excluir(Integer id) {
		pessoaDao.deleteById(id);
		listar();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}







    
}
