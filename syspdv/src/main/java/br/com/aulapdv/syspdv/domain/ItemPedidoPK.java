package br.com.aulapdv.syspdv.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemPedidoPK {
    
    @ManyToOne
    @JoinColumn(name="PRODUTO_ID")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="PEDIDO_ID")
    private Pedido pedido;

    public ItemPedidoPK(Produto produto, Pedido pedido) {
        this.produto = produto;
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public Pedido getPedido() {
        return pedido;
    }
}
