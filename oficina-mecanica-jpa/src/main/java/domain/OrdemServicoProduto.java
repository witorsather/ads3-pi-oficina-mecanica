package domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrdemServicoProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "ordemServicoProduto")
	private Produto produto;

	private Integer quantidade;

	private BigDecimal preco;

	@OneToOne(mappedBy = "ordemServicoProduto")
	private OrdemServico ordemServico;

	public OrdemServicoProduto() {
	}

	public OrdemServicoProduto(Integer id, Produto produto, Integer quantidade, BigDecimal preco,
			OrdemServico ordemServico) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.ordemServico = ordemServico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

}
