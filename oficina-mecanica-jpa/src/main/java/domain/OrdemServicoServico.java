package domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrdemServicoServico {

	private Integer id;
	
	private Servico servico;
	
	private Integer quantidade;
	
	private BigDecimal preco;
	
	@OneToOne(mappedBy = "ordemServicoServico")
	private OrdemServico ordemServico;


}
