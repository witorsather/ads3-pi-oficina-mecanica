package controller;

import java.util.ArrayList;
import java.util.List;

import domain.Servico;
import repository.ServicoRepository;

public class SpringManagedBean {

	private String seiLa = "OK ";
	
	private List<Servico> servicos = new ArrayList<>();
	
	private ServicoRepository servicoRepository;
	
	public void init() {
		this.servicos = servicoRepository.findAll();
	}
	
	public void acao() {
		seiLa += " Clicou";
	}

	public String getMessage() {
		return seiLa.toUpperCase();
	}

	public void setMessage(String message) {
		this.seiLa = message;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
}