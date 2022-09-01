package classes;

import enumeradores.statusOS;
import java.text.SimpleDateFormat;

public class OS {

    private int codigoDaOs;
    private int idfuncioanrioResponsavel;
    private float valorMaoDeobra;
    private int quantidadePecas;
    private float valorUnitarioPecas;
    private int idVeiculo;
    private int idCliente;
    private int idServico;
    private statusOS status;
    private int idPeca;

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public OS() {
    }

    public OS(int codigoDaOs, int idfuncioanrioResponsavel, float valorMaoDeobra, int quantidadePecas, int idVeiculo, int idCliente, int idServico, statusOS status) {
        this.codigoDaOs = codigoDaOs;
        this.idfuncioanrioResponsavel = idfuncioanrioResponsavel;
        this.valorMaoDeobra = valorMaoDeobra;
        this.quantidadePecas = quantidadePecas;
        this.idVeiculo = idVeiculo;
        this.idCliente = idCliente;
        this.idServico = idServico;
        this.status = status;
    }

    public int getCodigoDaOs() {
        return codigoDaOs;
    }

    public void setCodigoDaOs(int codigoDaOs) {
        this.codigoDaOs = codigoDaOs;
    }

    public int getIdfuncioanrioResponsavel() {
        return idfuncioanrioResponsavel;
    }

    public void setIdfuncioanrioResponsavel(int idfuncioanrioResponsavel) {
        this.idfuncioanrioResponsavel = idfuncioanrioResponsavel;
    }

    public float getValorMaoDeobra() {
        return valorMaoDeobra;
    }

    public void setValorMaoDeobra(float valorMaoDeobra) {
        this.valorMaoDeobra = valorMaoDeobra;
    }

    public int getQuantidadePecas() {
        return quantidadePecas;
    }

    public void setQuantidadePecas(int quantidadePecas) {
        this.quantidadePecas = quantidadePecas;
    }

    public float getValorUnitarioPecas() {
        return valorUnitarioPecas;
    }

    public void setValorUnitarioPecas(float valorUnitarioPecas) {
        this.valorUnitarioPecas = valorUnitarioPecas;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public statusOS getStatus() {
        return status;
    }

    public void setStatus(statusOS status) {
        this.status = status;
    }

    public float valorTotal(int QuantidadePecas, float valorServico, float ValorUnitarioPecas) {
        float total;
        QuantidadePecas = quantidadePecas;
        ValorUnitarioPecas = valorUnitarioPecas;
        valorServico = valorMaoDeobra;

        total = ((QuantidadePecas * ValorUnitarioPecas) + valorServico);

        return total;
    }

    @Override
    public String toString() {
        return codigoDaOs + ";" + idfuncioanrioResponsavel + ";" + valorMaoDeobra + ";" + idPeca + ";" + quantidadePecas + ";" + valorUnitarioPecas + ";" + idVeiculo + ";" + idCliente + ";" + idServico + ";" + status;
    }

}
