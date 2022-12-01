package br.com.aulapdv.syspdv.domain;

public enum TipoCliente {
    
    CPF(1, "Pessoa Física"),
    CNPJ(2, "Pessoa Jurídica");

    Integer valor;
    String tipoCliente;

    private TipoCliente(Integer valor, String tipoCliente) {
        this.valor = valor;
        this.tipoCliente = tipoCliente;
    }

    public Integer getValor() {
        return valor;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

}
