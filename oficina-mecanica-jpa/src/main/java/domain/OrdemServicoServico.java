package domain;

import java.math.BigDecimal;

public class OrdemServicoServico {

	private Integer id;
	
	private Servico servico;
	
	private Integer quantidade;
	
	private BigDecimal preco;

	public BigDecimal getTotal() {
		return BigDecimal.valueOf(preco.doubleValue() * quantidade);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
}
