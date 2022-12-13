package com.example.oficinaco.jpa.entidade;

public enum EnumOs {

    EMABERTO("Em aberto", 1),
    CANCELADA("Cancelada", 2),
    EMEXECUCAO("Em Execução", 3),
    FINALIZADA("Finalizada", 4);

    private int valor;
    private String descricao;

    private EnumOs(String descricao, int valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValor() {
        return valor;
    }

}
