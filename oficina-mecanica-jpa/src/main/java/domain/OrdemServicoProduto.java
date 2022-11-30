package domain;

import java.math.BigDecimal;

import javax.persistence.OneToOne;

public class OrdemServicoProduto {

	private Integer id;
	
	private Produto produto;
	
	private Integer quantidade;
	
	private BigDecimal preco;
	
	@OneToOne(mappedBy = "ordemServicoProduto")
	private OrdemServico ordemServico;
	
	
}
