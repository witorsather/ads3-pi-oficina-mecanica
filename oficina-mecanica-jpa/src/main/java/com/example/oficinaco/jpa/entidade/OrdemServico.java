package com.example.oficinaco.jpa.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ordem_servico_id")
	public List<OrdemServicoServico> servicos = new ArrayList<>();

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ordem_servico_id")
	public List<OrdemServicoProduto> produtos = new ArrayList<>();

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOs;

	@Enumerated(EnumType.STRING)
	private EnumOs status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioServico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimServico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrega;

	private BigDecimal valorTotal = BigDecimal.ZERO;

	public BigDecimal getTotalServicos() {
		BigDecimal vlr = BigDecimal.ZERO;
		for (OrdemServicoServico oss : servicos) {
			vlr = vlr.add(oss.getTotalServicos());
		}
		return vlr;
	}

	public BigDecimal getTotalProdutos() {
		BigDecimal vlr = BigDecimal.ZERO;
		for (OrdemServicoProduto osp : produtos) {
			vlr = vlr.add(osp.getTotalProdutos());
		}
		return vlr;
	}

	public BigDecimal getTotal() {
		return (getTotalProdutos().add(getTotalServicos()));
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", cliente, funcionario, veiculo);
	}

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

	public EnumOs getStatus() {
		return status;
	}

	public void setStatus(EnumOs status) {
		this.status = status;
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

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<OrdemServicoServico> getServicos() {
		return servicos;
	}

	public List<OrdemServicoProduto> getProdutos() {
		return produtos;
	}

	public Date getDataOs() {
		return dataOs;
	}

	public void setDataOs(Date dataOs) {
		this.dataOs = dataOs;
	}

}
