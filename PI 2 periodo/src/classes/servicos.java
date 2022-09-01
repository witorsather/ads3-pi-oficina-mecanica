package classes;

import enumeradores.tipoServicos;

public class servicos {

    private int codigoDoServico;
    private String descricao;
    private double valor;
    private int tempoDemorado;
    private tipoServicos tipo;

    public servicos() {
    }

    public servicos(int codigoDoServico, String descricao, double valor, int tempoDemorado) {
        this.codigoDoServico = codigoDoServico;
        this.descricao = descricao;
        this.valor = valor;
        this.tempoDemorado = tempoDemorado;
    }

    public tipoServicos getTipo() {
        return tipo;
    }

    public void setTipo(tipoServicos tipo) {
        this.tipo = tipo;
    }

    public int getCodigoDoServico() {
        return codigoDoServico;
    }

    public void setCodigoDoServico(int codigoDoServico) {
        this.codigoDoServico = codigoDoServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTempoDemorado() {
        return tempoDemorado;
    }

    public void setTempoDemorado(int tempoDemorado) {
        this.tempoDemorado = tempoDemorado;
    }

    @Override
    public String toString() {
        return codigoDoServico + ";" + descricao + ";" + valor + ";" + tempoDemorado + ";" + tipo;
    }
}
