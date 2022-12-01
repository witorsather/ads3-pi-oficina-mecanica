package br.com.aulapdv.syspdv.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate instance;

    @ManyToOne
    @JoinColumn(name="CLIENTE_ID")
    private Cliente cliente;

    @OneToOne(mappedBy="pedido")
    private Pagamento pagamento;

    @OneToMany(mappedBy="id.pedido")
    private List<ItemPedido> itemPedidos;

    @OneToOne
    @JoinColumn(name="ENDERECO_ID")
    private Endereco enderecoDeEntrega;

    public Pedido() {
    }

    public Pedido(Integer id, LocalDate instance, Endereco endereco, Cliente cliente, Pagamento pagamento) {
        this.id = id;
        this.instance = instance;
        this.enderecoDeEntrega = endereco;
        this.cliente = cliente;
        this.pagamento = pagamento;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getInstance() {
        return instance;
    }

    public void setInstance(LocalDate instance) {
        this.instance = instance;
    }

    public Endereco getEndereco() {
        return enderecoDeEntrega;
    }

    public void setEndereco(Endereco endereco) {
        this.enderecoDeEntrega = endereco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }
    
}
