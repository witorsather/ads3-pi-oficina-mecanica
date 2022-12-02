package com.example.oficinamecanicajpa.domain;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
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

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@ManyToOne(optional = false)
	@JoinColumn(name = "funcionario_id")
	private Pessoa funcionario;

	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;

	@OneToMany
	@JoinColumn(name = "ordem_servico_servico_id")
	private List<OrdemServicoServico> ordemServicoServicos;

	@OneToMany
	@JoinColumn(name = "ordem_servico_produto_id")
	private List<OrdemServicoProduto> ordemServicoProdutos;

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

	public OrdemServico() {
	}

	public OrdemServico(Integer id, Pessoa pessoa, Pessoa funcionario, Veiculo veiculo, Date data, Date dataEntrada,
			Date dataOs, Date dataInicioServico, Date dataFimServico, Date dataEntrega, BigDecimal desconto) {
		this.id = id;
		this.pessoa = pessoa;
		this.funcionario = funcionario;
		this.veiculo = veiculo;
		this.data = data;
		this.dataEntrada = dataEntrada;
		this.dataOs = dataOs;
		this.dataInicioServico = dataInicioServico;
		this.dataFimServico = dataFimServico;
		this.dataEntrega = dataEntrega;
		this.desconto = desconto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

	public List<OrdemServicoServico> getOrdemServicoServicos() {
		return ordemServicoServicos;
	}

	public void setOrdemServicoServicos(List<OrdemServicoServico> ordemServicoServicos) {
		this.ordemServicoServicos = ordemServicoServicos;
	}

	public List<OrdemServicoProduto> getOrdemServicoProdutos() {
		return ordemServicoProdutos;
	}

	public void setOrdemServicoProdutos(List<OrdemServicoProduto> ordemServicoProdutos) {
		this.ordemServicoProdutos = ordemServicoProdutos;
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

}
