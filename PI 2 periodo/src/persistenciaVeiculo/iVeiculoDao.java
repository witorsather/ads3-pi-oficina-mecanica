/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistenciaVeiculo;
import classes.*;
import java.util.ArrayList;

/**
 *
 * @author ALUNO
 */
public interface iVeiculoDao {

    void incluir(veiculo objetoV) throws Exception;
    veiculo consultar(int id) throws Exception;
    void excluir(int id) throws Exception;
    ArrayList<veiculo> obterVeiculo() throws Exception;

}
