package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
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
	

}
