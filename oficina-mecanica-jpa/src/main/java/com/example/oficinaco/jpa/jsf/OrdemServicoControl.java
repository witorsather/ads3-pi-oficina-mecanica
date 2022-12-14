package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.OrdemServicoDao;
import com.example.oficinaco.jpa.dao.PessoaDao;
import com.example.oficinaco.jpa.dao.PessoaDaoImpl;
import com.example.oficinaco.jpa.dao.ProdutoDao;
import com.example.oficinaco.jpa.dao.ServicoDao;
import com.example.oficinaco.jpa.dao.VeiculoDao;
import com.example.oficinaco.jpa.entidade.EnumOs;
import com.example.oficinaco.jpa.entidade.OrdemServico;
import com.example.oficinaco.jpa.entidade.OrdemServicoProduto;
import com.example.oficinaco.jpa.entidade.OrdemServicoServico;
import com.example.oficinaco.jpa.entidade.Pessoa;
import com.example.oficinaco.jpa.entidade.Produto;
import com.example.oficinaco.jpa.entidade.Servico;
import com.example.oficinaco.jpa.entidade.Veiculo;

@Component
@SessionScoped
public class OrdemServicoControl {

	// atributos para compor a OS
	private Integer pessoaId;

	private Integer servicoId;

	private Integer produtoId;

	private Integer funcionarioId;

	private Integer veiculoId;

	private String placa;

	private OrdemServico ordemServico = new OrdemServico();

	private OrdemServicoProduto ordemServicoProduto = new OrdemServicoProduto();

	private OrdemServicoServico ordemServicoServico = new OrdemServicoServico();

	private List<OrdemServico> ordemServicos = new ArrayList<>();

	// Classes dao para fazer o crud e instanciar os metodos complete
	@Autowired
	private PessoaDaoImpl pessoaDaoImpl;

	@Autowired
	private ServicoDao servicoDao;

	@Autowired
	private PessoaDao pessoaDao;

	@Autowired
	private VeiculoDao veiculoDao;

	@Autowired
	private ProdutoDao produtoDao;

	@Autowired
	private OrdemServicoDao ordemServicoDao;

	@PostConstruct
	public void init() {
		listar();
	}

	// metodos para selecionar os valores vindo da tela e passar para os atributos
	// da OS
	public void selecionarServico() {
		Servico servico = servicoDao.findById(servicoId).get();
		ordemServicoServico.setServico(servico);
		ordemServicoServico.setPreco(servico.getPreco());

	}

	public void selecionarProduto() {
		Produto produto = produtoDao.findById(produtoId).get();
		ordemServicoProduto.setProduto(produto);
		ordemServicoProduto.setPreco(produto.getPrecoVenda());
	}

	public void selecionarFuncionario() {
		Pessoa funcionario = pessoaDao.findById(funcionarioId).get();
		ordemServico.setFuncionario(funcionario);
	}

	public void selecionarVeiculo() {
		Veiculo veiculo = veiculoDao.findById(veiculoId).get();
		ordemServico.setVeiculo(veiculo);

	}

	// metodo para adicionar ordem servico
	public void adicionarServicoLista() {
		ordemServico.getServicos().add(ordemServicoServico);
		servicoId = null;
		ordemServicoServico = new OrdemServicoServico();
		listarServicos();
	}

	public void adicionarProdutoLista() {
		ordemServico.getProdutos().add(ordemServicoProduto);
		produtoId = null;
		ordemServicoProduto = new OrdemServicoProduto();
		listarProdutos();
	}

	// metodo para salvar a OS
	public void salvar() {
		ordemServico.setValorTotal(ordemServico.getTotal());
		ordemServico.setStatus(EnumOs.EMABERTO);
		ordemServico.setDataOs(new Date());
		ordemServicoDao.save(ordemServico);
		ordemServico = new OrdemServico();
		listar();
	}

	public void aprovarOs() {
		ordemServico.getId();
		ordemServico.setStatus(EnumOs.EMEXECUCAO);
		OrdemServico os = ordemServicoDao.findById(pessoaId).get();
		os.setStatus(EnumOs.EMEXECUCAO);
		ordemServico.setDataInicioServico(new Date());
		ordemServicoDao.save(ordemServico);
		ordemServico = new OrdemServico();
		listar();

	}

	public void finalizarOs() {
		ordemServico.setStatus(EnumOs.FINALIZADA);
		ordemServico.setDataFimServico(new Date());
		ordemServicoDao.save(ordemServico);
		ordemServico = new OrdemServico();
		listar();
	}

	public void cancelarOS() {
		ordemServico.setStatus(EnumOs.CANCELADA);
		ordemServicoDao.save(ordemServico);
		ordemServico = new OrdemServico();
		listar();
	}

	public void listar() {
		ordemServicos = ordemServicoDao.findAll();
	}

	// metodos para retornar lista de produtos e servicos adicionados a OS
	public void listarProdutos() {
		ordemServico.getProdutos();
	}

	public void listarServicos() {
		ordemServico.getServicos();
	}

	// metodos para fazer os completes para a tela
	public List<Pessoa> completePessoa(String query) {
		return pessoaDaoImpl.listarPorNome("%" + query + "%", null);
	}

	public List<Servico> completeServico(String query) {
		return servicoDao.listarPorNome("%" + query + "%");
	}

	public List<Produto> completeProduto(String query) {
		return produtoDao.listarPorNome("%" + query + "%");
	}

	public List<Pessoa> completeFuncionario(String query) {
		return pessoaDaoImpl.listarPorNome("%" + query + "%", true);
	}

	public List<Veiculo> completeVeiculo(String query) {
		return veiculoDao.consultarPorPlaca("%" + query + "%");
	}

	// getters and setters dos atributos da OS
	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Integer getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Integer veiculoId) {
		this.veiculoId = veiculoId;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public OrdemServicoProduto getOrdemServicoProduto() {
		return ordemServicoProduto;
	}

	public void setOrdemServicoProduto(OrdemServicoProduto ordemServicoProduto) {
		this.ordemServicoProduto = ordemServicoProduto;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public OrdemServicoServico getOrdemServicoServico() {
		return ordemServicoServico;
	}

	public void setOrdemServicoServico(OrdemServicoServico ordemServicoServico) {
		this.ordemServicoServico = ordemServicoServico;
	}

	public List<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}

}
