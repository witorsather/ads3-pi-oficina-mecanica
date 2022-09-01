/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import enumeradores.tipoModeloVeiculo;

/**
 *
 * @author ALUNO
 */
public class veiculo {

    private int ID;
    private int idCliente;
    private marca marcaVeiculo;
    private modelo modeloVeiculo;
    private String placa;
    private String renavam;
    private tipoModeloVeiculo tipo;

    public veiculo() {
    }
    public veiculo(int ID, int idCliente, marca marcaVeiculo, modelo modeloVeiculo, String placa, String renavam, tipoModeloVeiculo tipo) {
        this.ID = ID;
        this.idCliente = idCliente;
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.placa = placa;
        this.renavam = renavam;
        this.tipo = tipo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public marca getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(marca marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public modelo getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(modelo modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

     public boolean setPlaca(String placa) {
         String PLACA;
     if (placa.length() == 8) {
         PLACA = desformatarPlaca (placa);
            if (PLACA.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}") || PLACA.matches("[A-Z]{3}[0-9]{4}")) {
                this.placa = placa;
                return true;
            } else return false;
        }
     if (placa.length() != 8) {
         return false;
     }
     return true;
    }
    //this.placa = this.placa;
     public String desformatarPlaca (String placa) {
         return placa.replace("-", "");
     }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public tipoModeloVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(tipoModeloVeiculo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return ID + ";" + idCliente + ";" + marcaVeiculo + ";" + modeloVeiculo + ";" + placa + ";" + renavam + ";" + tipo;
    }

}
