package persistenciaEstoque;

import classes.estoque;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import persistenciaCliente.GeradorIdentificadorCliente;

public class EstoqueDao implements iEstoqueDao {

    private String nomeDoArquivoNoDisco = "estoque.txt";

    public EstoqueDao() {
    }

    @Override
    public void incluir(estoque objeto) throws Exception {
        try {
            int id = GeradorIdentificadorEstoque.getID();
            objeto.setId(id);
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto.toString() + "\n");
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public void alterar(estoque objeto, int id) throws Exception {
        ArrayList<estoque> listaEstoque = null;
        listaEstoque = obterPecas();
        excluir(id);
        FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(objeto.toString() + "\n");
        bw.close();

    }

    @Override
    public estoque consultar(int id) throws Exception {

        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                estoque objetoPecas = new estoque();
                String vetorString[] = linha.split(";");
                if (vetorString.length != 5) {
                    throw new Exception("Faltam dados na String");

                }
                objetoPecas.setCodigo(Integer.parseInt(vetorString[0]));
                objetoPecas.setDescricao(vetorString[1]);
                objetoPecas.setCodigo(Integer.parseInt(vetorString[2]));
                objetoPecas.setValorUnidade(Float.parseFloat(vetorString[3]));
                objetoPecas.setQuantidadePecas(Integer.parseInt(vetorString[4]));
                if (objetoPecas.getId() == id) {
                    return objetoPecas;

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
            ArrayList<estoque> listaPecas = null;
            listaPecas = obterPecas();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeDoArquivoNoDisco))) {

                for (int i = 0; i < listaPecas.size(); i++) {
                    if (listaPecas.get(i).getId() != id) {
                        estoque teste = listaPecas.get(i);
                        bw.write(listaPecas.get(i).toString() + "\n");

                    }

                }
            }

        } catch (Exception erro) {
            throw erro;
        }
    }

    public ArrayList<estoque> obterPecas() throws Exception {

        ArrayList<estoque> listaPecas = new ArrayList<estoque>();
        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null) {
            estoque objetoPecas = new estoque();
            String vetorString[] = linha.split(";");
            if (vetorString.length != 5) {
                throw new Exception("Faltam dados na String");

            }
            objetoPecas.setId(Integer.parseInt(vetorString[0]));
            objetoPecas.setDescricao(vetorString[1]);
            objetoPecas.setCodigo(Integer.parseInt(vetorString[2]));
            objetoPecas.setValorUnidade(Float.parseFloat(vetorString[3]));
            objetoPecas.setQuantidadePecas(Integer.parseInt(vetorString[4]));
            listaPecas.add(objetoPecas);
        }
        return listaPecas;
    }
}
