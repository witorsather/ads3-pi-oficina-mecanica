package persistenciaServicos;

import persistenciaServicos.*;
import classes.servicos;
import enumeradores.tipoServicos;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import persistenciaCliente.GeradorIdentificadorCliente;

public class ServicosDao implements iServicosDao {

    private String nomeDoArquivoNoDisco = "servicos.txt";

    @Override
    public void incluir(servicos objeto) throws Exception {

        try {
            int id = GeradorIdentificadorServicos.getID();
            objeto.setCodigoDoServico(id);
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto.toString() + "\n");
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(servicos objeto, int id) throws Exception {

        ArrayList<servicos> listaServicos = null;
        listaServicos = obterServicos();
        excluir(id);
        FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(objeto.toString() + "\n");
        bw.close();
    }

    @Override
    public servicos consultar(int id) throws Exception {

        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                servicos objetoServicos = new servicos();
                String vetorString[] = linha.split(";");
                if (vetorString.length != 4) {
                    throw new Exception("Faltam dados na String");

                }
                objetoServicos.setCodigoDoServico(Integer.parseInt(vetorString[0]));
                objetoServicos.setDescricao(vetorString[1]);
                objetoServicos.setValor(Float.parseFloat(vetorString[2]));
                objetoServicos.setTempoDemorado(Integer.parseInt(vetorString[3]));
                objetoServicos.setTipo(Enum.valueOf(tipoServicos.class, vetorString[4]));
                if (objetoServicos.getCodigoDoServico() == id) {
                    return objetoServicos;
                }
            }
            br.close();
            throw new Exception("Código de Serviço não existe");

        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            ArrayList<servicos> servicos = null;
            servicos = obterServicos();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeDoArquivoNoDisco))) {

                for (int i = 0; i < servicos.size(); i++) {
                    if (servicos.get(i).getCodigoDoServico() != id) {
                        servicos teste = servicos.get(i);
                        bw.write(servicos.get(i).toString() + "\n");

                    }

                }
            }

        } catch (Exception erro) {
            throw erro;
        }
    }

    public ArrayList<servicos> obterServicos() throws Exception {

        ArrayList<servicos> listaServicos = new ArrayList<servicos>();
        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null) {
            servicos objetoServicos = new servicos();
            String vetorString[] = linha.split(";");
            if (vetorString.length != 5) {
                throw new Exception("Faltam dados na String");

            }
            objetoServicos.setCodigoDoServico(Integer.parseInt(vetorString[0]));
            objetoServicos.setDescricao(vetorString[1]);
            objetoServicos.setValor(Float.parseFloat(vetorString[2]));
            objetoServicos.setTempoDemorado(Integer.parseInt(vetorString[3]));
            objetoServicos.setTipo(Enum.valueOf(tipoServicos.class, vetorString[4]));
            listaServicos.add(objetoServicos);
        }
        return listaServicos;
    }
}
