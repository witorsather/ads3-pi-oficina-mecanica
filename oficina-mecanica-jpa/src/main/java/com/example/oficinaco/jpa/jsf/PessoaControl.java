package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.oficinaco.jpa.dao.MunicipioDao;
import com.example.oficinaco.jpa.dao.PessoaDao;
import com.example.oficinaco.jpa.entidade.CpfCnpjValidacao;
import com.example.oficinaco.jpa.entidade.Municipio;
import com.example.oficinaco.jpa.entidade.Pessoa;

@Component
@SessionScope
public class PessoaControl {

	@Autowired
	private PessoaDao pessoaDao;

	@Autowired
	private MunicipioDao municipioDao;

	private Integer municipioId;

	private Boolean funcionario;

	private Boolean whatsApp;

	private Pessoa pessoa = new Pessoa();

	private List<Pessoa> pessoas = new ArrayList<>();

	private List<Pessoa> pessoasFiltro = new ArrayList<>();

	@PostConstruct
	public void init() {
		listar();
	}

	public void addMessageFuncionario() {

		String summary = funcionario ? "Checked" : "Unchecked";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));

		if (summary.equals("Checked")) {

			pessoa.setFuncionario(true);

		} else if (summary.equals("Unchecked")) {

			pessoa.setFuncionario(false);

		}
	}

	public void addMessageWhatsApp() {

		String summary2 = whatsApp ? "Checked" : "Unchecked";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary2));

		if (summary2.equals("Checked")) {

			pessoa.setWhatsapp(true);

		} else if (summary2.equals("Unchecked")) {

			pessoa.setWhatsapp(false);

		}
	}

	public List<Municipio> completeMunicipio(String query) {
		return municipioDao.listarPorNome("%" + query + "%");
	}

	public void selecionarMunicipio() {
		Municipio municipio = municipioDao.findById(municipioId).get();
		pessoa.setMunicipio(municipio);
	}

	public void salvar() {
		if (CpfCnpjValidacao.isCnpjCpfValid(pessoa.getCpf())
				&& CpfCnpjValidacao.isCpfCnpjValidacaoLista(pessoas, pessoa.getCpf())) {
			pessoaDao.save(pessoa);
			pessoa = new Pessoa();
			listar();
		} else if (!CpfCnpjValidacao.isCpfCnpjValidacaoLista(pessoas, pessoa.getCpf())) {
			FacesContext.getCurrentInstance().addMessage("form:campoCPF", new FacesMessage("CPF já cadastrado!"));
		} else if (!CpfCnpjValidacao.isCnpjCpfValid(pessoa.getCpf())) {
			FacesContext.getCurrentInstance().addMessage("form:campoCPF", new FacesMessage("CPF inválido!"));
		}
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

	public MunicipioDao getMunicipioDao() {
		return municipioDao;
	}

	public void setMunicipioDao(MunicipioDao municipioDao) {
		this.municipioDao = municipioDao;
	}

	public Integer getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Integer municipioId) {
		this.municipioId = municipioId;
	}

	public Boolean getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Boolean funcionario) {
		this.funcionario = funcionario;
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public Boolean getWhatsApp() {
		return whatsApp;
	}

	public void setWhatsApp(Boolean whatsApp) {
		this.whatsApp = whatsApp;
	}

	public List<Pessoa> getPessoasFiltro() {
		return pessoasFiltro;
	}

	public void setPessoasFiltro(List<Pessoa> pessoasFiltro) {
		this.pessoasFiltro = pessoasFiltro;
	}
}