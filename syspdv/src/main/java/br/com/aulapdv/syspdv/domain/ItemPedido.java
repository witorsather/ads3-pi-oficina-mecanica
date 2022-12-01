package br.com.aulapdv.syspdv.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ItemPedido {
    
    @EmbeddedId
    private ItemPedidoPK id;

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido(Produto produto, Pedido pedido) {
        this.id = new ItemPedidoPK(produto, pedido);
    }

    public ItemPedido(Double desconto, Integer quantidade, Double preco, Produto produto, Pedido pedido) {
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.id = new ItemPedidoPK(produto, pedido);
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return this.id.getProduto();
    }

    public Pedido getPedido() {
        return this.id.getPedido();
    }
}
