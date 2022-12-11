package com.example.oficinaco.jpa.jsf;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.primefaces.util.LangUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.oficinaco.jpa.dao.ServicoDao;
import com.example.oficinaco.jpa.entidade.Servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@SessionScoped
public class ServicoControl {

@Autowired
private ServicoDao servicoDao;

private Servico servico = new Servico();
	
private List<Servico> servicos = new ArrayList<>();

private int getInteger(String string) {
    try {
        return Integer.parseInt(string);
    }
    catch (NumberFormatException ex) {
        return 0;
    }
}

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
	    String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
	    if (LangUtils.isBlank(filterText)) {
	        return true;
	    }
	    int filterInt = getInteger(filterText);
	
	    Servico servico = (Servico) value;
	    
	    return servico.getNome().toLowerCase().contains(filterText);
	}

	@PostConstruct
	public void init() {
		listar();
	}
	
	public void salvar() {
		servicoDao.save(servico);
		servico = new Servico();
		listar();
	}
	
	public void listar() {
		servicos = servicoDao.findAll();
	}
	
	public void excluir(Integer id) {
		servicoDao.deleteById(id);
		listar();
	}

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
    
    
    
}
