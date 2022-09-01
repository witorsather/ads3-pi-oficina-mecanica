package persistenciaOS;

import classes.OS;
import classes.servicos;
import enumeradores.statusOS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import persistenciaServicos.GeradorIdentificadorServicos;

public class OsDao implements iOsDao {

    private String nomeDoArquivoNoDisco = "ordemServico.txt";

    @Override
    public void incluir(OS objeto) throws Exception {

        try {
            int id = GeradorIdentificadorOS.getID();
            objeto.setCodigoDaOs(id);
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto.toString() + "\n");
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public void alterar(OS objeto, int id) throws Exception {
        ArrayList<OS> listaOS = null;
        listaOS = obterOS();
        excluir(id);
        FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(objeto.toString() + "\n");
        bw.close();

    }

    @Override
    public OS consultar(int id) throws Exception {
        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                OS objetoOS = new OS();
                String vetorString[] = linha.split(";");
                if (vetorString.length != 10) {
                    throw new Exception("Faltam dados na String");

                }

                objetoOS.setCodigoDaOs(Integer.parseInt(vetorString[0]));
                objetoOS.setIdfuncioanrioResponsavel(Integer.parseInt(vetorString[1]));
                objetoOS.setValorMaoDeobra(Float.parseFloat(vetorString[2]));
                objetoOS.setIdPeca(Integer.parseInt(vetorString[3]));
                objetoOS.setQuantidadePecas(Integer.parseInt(vetorString[5]));
                objetoOS.setValorUnitarioPecas(Float.parseFloat(vetorString[6]));
                objetoOS.setIdVeiculo(Integer.parseInt(vetorString[7]));
                objetoOS.setIdCliente(Integer.parseInt(vetorString[8]));
                objetoOS.setIdServico(Integer.parseInt(vetorString[9]));
                objetoOS.setStatus(Enum.valueOf(statusOS.class, vetorString[10]));

                if (objetoOS.getCodigoDaOs() == id) {
                    return objetoOS;
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
            ArrayList<OS> listaOS = null;
            listaOS = obterOS();
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < listaOS.size(); i++) {
                if (listaOS.get(i).getCodigoDaOs() != id) {
                    bw.write(listaOS.get(i).toString() + "\n");

                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<OS> obterOS() throws Exception {
        ArrayList<OS> listaOS = new ArrayList<OS>();
        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null) {
            OS objetoOS = new OS();
            String vetorString[] = linha.split(";");
            if (vetorString.length != 10) {
                throw new Exception("Faltam dados na String");

            }
            objetoOS.setCodigoDaOs(Integer.parseInt(vetorString[0]));
            objetoOS.setIdfuncioanrioResponsavel(Integer.parseInt(vetorString[1]));
            objetoOS.setValorMaoDeobra(Float.parseFloat(vetorString[2]));
            objetoOS.setIdPeca(Integer.parseInt(vetorString[3]));
            objetoOS.setQuantidadePecas(Integer.parseInt(vetorString[4]));
            objetoOS.setValorUnitarioPecas(Float.parseFloat(vetorString[5]));
            objetoOS.setIdVeiculo(Integer.parseInt(vetorString[6]));
            objetoOS.setIdCliente(Integer.parseInt(vetorString[7]));
            objetoOS.setIdServico(Integer.parseInt(vetorString[8]));
            objetoOS.setStatus(Enum.valueOf(statusOS.class, vetorString[9]));
            listaOS.add(objetoOS);

        }
        br.close();
        return listaOS;

    }
}
