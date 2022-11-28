package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdemServico {

	private Integer id;
	
	private Pessoa cliente;
	
	private Pessoa funcionario;
	
	private Veiculo veiculo;
	
	private List<OrdemServicoServico> servicos = new ArrayList<>();

	private List<OrdemServicoProduto> produtos = new ArrayList<>();
	
	private Date data;
	
	private Date dataEntrada;
	
	private Date dataOs;
	
	private Date dataInicioServico;
	
	private Date dataFimServico;
	
	private Date dataEntrega;
	
	private BigDecimal desconto;

	public BigDecimal getTotalServicos() {
		BigDecimal vlr = BigDecimal.ZERO;
		for(OrdemServicoServico oss : servicos) {
			vlr = vlr.add(oss.getTotal());
		}
		return vlr;
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

}
