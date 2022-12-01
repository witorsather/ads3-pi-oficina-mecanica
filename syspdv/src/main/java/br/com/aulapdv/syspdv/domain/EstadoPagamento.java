package br.com.aulapdv.syspdv.domain;

public enum EstadoPagamento {
    
    PAGO(1, "Pago"),
    CANCELADO(2, "Cancelado"),
    PROCESSANDO(3, "Processando");

    Integer valor;
    String estadoPagamento;

    private EstadoPagamento(Integer valor, String estadoPagamento) {
        this.valor = valor;
        this.estadoPagamento = estadoPagamento;
    }

    public Integer getValor() {
        return valor;
    }

    public String getEstadoPagamento() {
        return estadoPagamento;
    }
}
