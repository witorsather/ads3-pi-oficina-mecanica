/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistenciaVeiculo;

import enumeradores.tipoModeloVeiculo;
import classes.cliente;
import classes.marca;
import classes.modelo;
import classes.veiculo;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

/**
 *
 * @author ALUNO
 */
public class veiculoDao implements iVeiculoDao {

    String nomeDoArquivoNoDisco = "veiculo.txt";

    @Override
    public void incluir(veiculo objetoV) throws Exception {

        try {
            int id = GeradorIdentificadorVeiculo.getID();
            objetoV.setID(id);
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objetoV.toString() + "\n");
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public veiculo consultar(int id) throws Exception {
        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";

            while ((linha = br.readLine()) != null) {
                marca objetoMarca = new marca();
                modelo objetoModelo = new modelo();
                veiculo objetoVeiculo = new veiculo();
                String vetorVeiculo[] = linha.split(";");
                String marca[] = vetorVeiculo[2].split(",");
                String modelo[] = vetorVeiculo[3].split(",");

                if (vetorVeiculo.length != 7) {
                    throw new Exception("Faltam dados no cadastro!");
                }
                objetoMarca.setDescricao(marca[0]);
                objetoMarca.setLogo(marca[1]);
                //
                objetoModelo.setDescricao(modelo[0]);
                objetoModelo.setAnoFabricacao(Integer.parseInt(modelo[1]));
                objetoModelo.setAnoModelo(Integer.parseInt(modelo[2]));
                //
                objetoVeiculo.setID(Integer.parseInt(vetorVeiculo[0]));
                objetoVeiculo.setIdCliente(Integer.parseInt(vetorVeiculo[1]));
                objetoVeiculo.setMarcaVeiculo(objetoMarca);
                objetoVeiculo.setModeloVeiculo(objetoModelo);
                objetoVeiculo.setPlaca(vetorVeiculo[4]);
                objetoVeiculo.setRenavam(vetorVeiculo[5]);
                objetoVeiculo.setTipo(Enum.valueOf(tipoModeloVeiculo.class, vetorVeiculo[6]));
                if (objetoVeiculo.getID() == id) {
                    return objetoVeiculo;

                }
            }
            br.close();
            throw new Exception("Veículo não cadastrado");
        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            ArrayList<veiculo> listaVeiculo = null;
            listaVeiculo = obterVeiculo();
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < listaVeiculo.size(); i++) {
                if (listaVeiculo.get(i).getID() != id) {

                    bw.write(listaVeiculo.get(i).toString() + "\n");

                }
            }

            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }
    @Override
    public ArrayList<veiculo> obterVeiculo() throws Exception {
        ArrayList<veiculo> listaVeiculo = new ArrayList<veiculo>();
        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";

        while ((linha = br.readLine()) != null) {
            marca objetoMarca = new marca();
            modelo objetoModelo = new modelo();
            veiculo objetoVeiculo = new veiculo();
            String vetorVeiculo[] = linha.split(";");
            String marca[] = vetorVeiculo[2].split(",");
            String modelo[] = vetorVeiculo[3].split(",");

            if (vetorVeiculo.length != 7) {
                throw new Exception("Faltam dados no cadastro!");
            }
            objetoMarca.setDescricao(marca[0]);
            objetoMarca.setLogo(marca[1]);
            //
            objetoModelo.setDescricao(modelo[0]);
            objetoModelo.setAnoFabricacao(Integer.parseInt(modelo[1]));
            objetoModelo.setAnoModelo(Integer.parseInt(modelo[2]));
            //
            objetoVeiculo.setID(Integer.parseInt(vetorVeiculo[0]));
            objetoVeiculo.setIdCliente(Integer.parseInt(vetorVeiculo[1]));
            objetoVeiculo.setMarcaVeiculo(objetoMarca);
            objetoVeiculo.setModeloVeiculo(objetoModelo);
            objetoVeiculo.setPlaca(vetorVeiculo[4]);
            objetoVeiculo.setRenavam(vetorVeiculo[5]);
            objetoVeiculo.setTipo(Enum.valueOf(tipoModeloVeiculo.class, vetorVeiculo[6]));
            listaVeiculo.add(objetoVeiculo);

        }
        br.close();
        return listaVeiculo;
    }
}
