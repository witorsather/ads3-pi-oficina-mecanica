package com.example.oficinaco.jpa.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(optional = false)
	private Pessoa cliente;
	
	@ManyToOne(optional = false)
	private Pessoa funcionario;
	
	@ManyToOne(optional = false)
	private Veiculo veiculo;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ordem_servico_id")
	public List<OrdemServicoServico> servicos = new ArrayList<>();

	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ordem_produto_id")
	public List<OrdemServicoProduto> produtos = new ArrayList<>();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrada;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOs;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioServico;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimServico;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrega;
	
	private BigDecimal desconto;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Pessoa getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Pessoa funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataOs() {
		return dataOs;
	}

	public void setDataOs(Date dataOs) {
		this.dataOs = dataOs;
	}

	public Date getDataInicioServico() {
		return dataInicioServico;
	}

	public void setDataInicioServico(Date dataInicioServico) {
		this.dataInicioServico = dataInicioServico;
	}

	public Date getDataFimServico() {
		return dataFimServico;
	}

	public void setDataFimServico(Date dataFimServico) {
		this.dataFimServico = dataFimServico;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public List<OrdemServicoServico> getServicos() {
		return servicos;
	}

	public List<OrdemServicoProduto> getProdutos() {
		return produtos;
	}

	public BigDecimal getTotalServicos() {
		BigDecimal vlServico = BigDecimal.ZERO;
		for(OrdemServicoServico oss : servicos) {
			vlServico = vlServico.add(oss.getTotal());
		}

		BigDecimal vlProduto = BigDecimal.ZERO;
		for(OrdemServicoServico oss : servicos) {
			vlProduto = vlProduto.add(oss.getTotal());
		}

		BigDecimal vlFinal = BigDecimal.ZERO;
		vlFinal.add(vlServico);
		vlFinal.add(vlProduto);
		return vlFinal;
	}
	
}
