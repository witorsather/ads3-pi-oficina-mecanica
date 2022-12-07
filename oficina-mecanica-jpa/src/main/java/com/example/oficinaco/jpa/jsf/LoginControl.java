package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.LoginDao;
import com.example.oficinaco.jpa.entidade.Login;

@Component
@SessionScoped
public class LoginControl {
	
	@Autowired
	private LoginDao loginDao;
	
	private Login login = new Login();
	
	private List<Login> logins = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		listar();
	}
	
	public void salvar() {
		loginDao.save(login);
		login = new Login();
		listar();
	}
	
	public void listar() {
		logins = loginDao.findAll();
	}
	
	public void excluir(Integer id) {
		loginDao.deleteById(id);
		listar();
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}
	
	
	
}














