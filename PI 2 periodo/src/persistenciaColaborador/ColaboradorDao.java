package persistenciaColaborador;

import persistenciaCliente.*;
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

public class ColaboradorDao implements iColaboradorDao {

    private String nomeDoArquivoNoDisco = "colaborador.txt";

    @Override
    public void incluir(colaborador objeto) throws Exception {

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
    public void alterar(colaborador objeto, int id) throws Exception {

        ArrayList<colaborador> listaCliente = null;
        listaCliente = obterColaborador();
        excluir(id);
        FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(objeto.toString() + "\n");
        bw.close();
    }

    @Override
    public colaborador consultar(int id) throws Exception {
        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                colaborador objetoColaborador = new colaborador();
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
                objetoColaborador.setNome(vetorString[0]);
                objetoColaborador.setID(Integer.parseInt(vetorString[2]));
                objetoColaborador.setEmail(vetorString[4]);
                objetoColaborador.setCPF(vetorString[5]);
                objetoColaborador.setDataNascimento((vetorString[6]));
                objetoColaborador.setSalarioMensal(Float.parseFloat(vetorString[7]));
                objetoColaborador.setSalarioHora(Float.parseFloat(vetorString[8]));
                objetoColaborador.setEspecialidade(vetorString[9]);
                objetoColaborador.setTelefone(objetoTelefone);
                objetoColaborador.setEndereco(objetoEndereco);

                if (objetoColaborador.getID() == id) {
                    return objetoColaborador;
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
            ArrayList<colaborador> listaCliente = null;
            listaCliente = obterColaborador();
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

    public ArrayList<colaborador> obterColaborador() throws Exception {

        ArrayList<colaborador> listaColaborador = new ArrayList<colaborador>();

        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null) {
            //objetos para fazer set das classes
            colaborador objetoColaborador = new colaborador();
            endereco objetoEndereco = new endereco();
            telefone objetoTelefone = new telefone();
            // vetores para fazer set
            String vetorString[] = linha.split(";");
            String ende[] = vetorString[3].split(",");
            String tele[] = vetorString[1].split(",");

            if (vetorString.length != 10) {
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
            objetoColaborador.setNome(vetorString[0]);
            objetoColaborador.setID(Integer.parseInt(vetorString[2]));
            objetoColaborador.setEmail(vetorString[4]);
            objetoColaborador.setCPF(vetorString[5]);
            objetoColaborador.setDataNascimento((vetorString[6]));
            objetoColaborador.setSalarioMensal(Float.parseFloat(vetorString[7]));
            objetoColaborador.setSalarioHora(Float.parseFloat(vetorString[8]));
            objetoColaborador.setEspecialidade(vetorString[9]);
            objetoColaborador.setTelefone(objetoTelefone);
            objetoColaborador.setEndereco(objetoEndereco);
            listaColaborador.add(objetoColaborador);

        }

        br.close();
        return listaColaborador;

    }

}
