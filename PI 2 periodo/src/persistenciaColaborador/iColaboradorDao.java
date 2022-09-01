/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistenciaColaborador;
import persistenciaCliente.*;
import classes.*;
import java.util.ArrayList;
/**
 *
 * @author ALUNO
 */
public interface iColaboradorDao {
    
    void incluir(colaborador objeto)throws Exception;
    void alterar(colaborador objeto, int id) throws Exception;
    colaborador consultar(int id) throws Exception;
    void excluir(int id)throws Exception;
    ArrayList<colaborador> obterColaborador()throws Exception;
}
