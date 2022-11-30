package controller;

import java.util.List;

import domain.OrdemServico;
import domain.OrdemServicoServico;
import domain.Pessoa;
import domain.Servico;

import repository.PessoaImplRepository;
import repository.PessoaRepository;
import repository.ServicoRepository;
import repository.VeiculoRepository;

public class OrdemServicoControl {

	private Integer pessoaId;

	private Integer servicoId;

	private Integer funcionarioId;

	private PessoaRepository PessoaRepository;

	private VeiculoRepository veiculoRepository;

	private String placa;

	private OrdemServico ordemServico = new OrdemServico();

	private OrdemServicoServico ordemServicoServico = new OrdemServicoServico();

	private PessoaImplRepository PessoaImplRepository;

	private ServicoRepository servicoRepository;

	public List<Pessoa> completePessoa(String query) {
		return PessoaImplRepository.listarPorNome("%" + query + "%", null);
	}

	public List<Servico> completeServico(String query) {
		return servicoRepository.listarPorNome("%" + query + "%");
	}

	public List<Pessoa> completeFuncionario(String query) {
		return PessoaImplRepository.listarPorNome("%" + query + "%", true);
	}

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

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public OrdemServicoServico getOrdemServicoServico() {
		return ordemServicoServico;
	}

	public void setOrdemServicoServico(OrdemServicoServico ordemServicoServico) {
		this.ordemServicoServico = ordemServicoServico;
	}

	public PessoaRepository getPessoaRepository() {
		return PessoaRepository;
	}

	public void setPessoaRepository(PessoaRepository pessoaRepository) {
		PessoaRepository = pessoaRepository;
	}

	public VeiculoRepository getVeiculoRepository() {
		return veiculoRepository;
	}

	public void setVeiculoRepository(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	public PessoaImplRepository getPessoaImplRepository() {
		return PessoaImplRepository;
	}

	public void setPessoaImplRepository(PessoaImplRepository pessoaImplRepository) {
		PessoaImplRepository = pessoaImplRepository;
	}

	public ServicoRepository getServicoRepository() {
		return servicoRepository;
	}

	public void setServicoRepository(ServicoRepository servicoRepository) {
		this.servicoRepository = servicoRepository;
	}

}