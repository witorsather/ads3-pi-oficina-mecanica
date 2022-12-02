package com.example.oficinamecanicajpa.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

@Entity
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private BigDecimal preco;

	@ManyToOne
	@JoinColumn(name = "servico_id")
	private OrdemServicoServico ordemServicoServico;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public OrdemServicoServico getOrdemServicoServico() {
		return ordemServicoServico;
	}

	public void setOrdemServicoServico(OrdemServicoServico ordemServicoServico) {
		this.ordemServicoServico = ordemServicoServico;
	}

	@Override
	public String toString() {
		return String.format("%s - %s", nome, preco);
	}

}
