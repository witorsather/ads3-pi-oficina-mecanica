package persistenciaCliente;

import classes.*;
import enumeradores.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.text.DateFormat;

public class ClienteDao implements iClienteDao {

    private String nomeDoArquivoNoDisco = "cliente.txt";

    @Override
    public void incluir(cliente objeto) throws Exception {

        try {
            int id = GeradorIdentificadorCliente.getID();
            objeto.setID(id);
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto.toString() + "\n");
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public void alterar(cliente objeto, int id) throws Exception {

        ArrayList<cliente> listaCliente = null;
        listaCliente = obterClientes();
        excluir(id);
        FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(objeto.toString() + "\n");
        bw.close();
    }

    @Override
    public cliente consultar(int id) throws Exception {
        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                cliente objetoCliente = new cliente();
                String vetorString[] = linha.split(";");
                String ende[] = vetorString[3].split(",");
                String tele[] = vetorString[1].split(",");
                if (vetorString.length != 9) {
                    throw new Exception("Faltam dados na String");
                }

                telefone objetoTelefone = new telefone();
                endereco objetoEndereco = new endereco();

                // posicao vetor endereco
                objetoEndereco.setLogradouro(ende[0]);
                objetoEndereco.setNumero(ende[1]);
                objetoEndereco.setBairro(ende[2]);
                objetoEndereco.setComplemento(ende[3]);
                objetoEndereco.setCidade(ende[4]);
                objetoEndereco.setEstado(ende[5]);
                objetoEndereco.setCep((ende[6]));
                objetoEndereco.setTipo(Enum.valueOf(tipoLogradouro.class, ende[7]));

                // posicao vetor telefone
                objetoTelefone.setTelefone((tele[1]));
                objetoTelefone.setTipo(Enum.valueOf(tiposTelefone.class, tele[0]));

                // posicao vetor principal
                objetoCliente.setNome(vetorString[0]);
                objetoCliente.setID(Integer.parseInt(vetorString[2]));
                objetoCliente.setEmail(vetorString[4]);
                objetoCliente.setTipoCliente(Enum.valueOf(tipoCliente.class, vetorString[5]));
                objetoCliente.setCPF_CNPJ(vetorString[6]);
                objetoCliente.setDataNascimento((vetorString[7]));
                objetoCliente.setRazaoSocial(vetorString[8]);
                objetoCliente.setTelefone(objetoTelefone);
                objetoCliente.setEndereco(objetoEndereco);

                if (objetoCliente.getID() == id) {
                    return objetoCliente;
                }
            }
            br.close();
            throw new Exception("ID não existe");
        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public void excluir(int id) throws Exception {

        try {
            ArrayList<cliente> listaCliente = null;
            listaCliente = obterClientes();
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).getID() != id) {
                    bw.write(listaCliente.get(i).toString() + "\n");

                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }

    }

    public ArrayList<cliente> obterClientes() throws Exception {

        ArrayList<cliente> listaCliente = new ArrayList<cliente>();

        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null) {
            //objetos para fazer set das classes
            cliente objetoCliente = new cliente();
            telefone objetoTelefone = new telefone();
            endereco objetoEndereco = new endereco();
            // vetores para fazer set
            String vetorString[] = linha.split(";");
            String ende[] = vetorString[3].split(",");
            String tele[] = vetorString[1].split(",");

            if (vetorString.length != 9) {
                throw new Exception("Faltam dados na String");
            }

            // posicao vetor endereco
            objetoEndereco.setLogradouro(ende[0]);
            objetoEndereco.setNumero(ende[1]);
            objetoEndereco.setBairro(ende[2]);
            objetoEndereco.setComplemento(ende[3]);
            objetoEndereco.setCidade(ende[4]);
            objetoEndereco.setEstado(ende[5]);
            objetoEndereco.setCep((ende[6]));
            objetoEndereco.setTipo(Enum.valueOf(tipoLogradouro.class, ende[7]));

            // posicao vetor telefone
            objetoTelefone.setTelefone((tele[1]));
            objetoTelefone.setTipo(Enum.valueOf(tiposTelefone.class, tele[0]));

            // posicao vetor principal
            objetoCliente.setNome(vetorString[0]);
            objetoCliente.setID(Integer.parseInt(vetorString[2]));
            objetoCliente.setEmail(vetorString[4]);
            objetoCliente.setTipoCliente(Enum.valueOf(tipoCliente.class, vetorString[5]));
            objetoCliente.setCPF_CNPJ(vetorString[6]);
            objetoCliente.setDataNascimento((vetorString[7]));
            objetoCliente.setRazaoSocial(vetorString[8]);
            objetoCliente.setTelefone(objetoTelefone);
            objetoCliente.setEndereco(objetoEndereco);
            listaCliente.add(objetoCliente);

        }

        br.close();
        return listaCliente;

    }

}
