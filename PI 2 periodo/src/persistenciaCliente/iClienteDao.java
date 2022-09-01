/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistenciaCliente;
import classes.*;
import java.util.ArrayList;
/**
 *
 * @author ALUNO
 */
public interface iClienteDao {
    
    void incluir(cliente objeto)throws Exception;
    void alterar(cliente objeto, int id) throws Exception;
    cliente consultar(int id) throws Exception;
    void excluir(int id)throws Exception;
    ArrayList<cliente> obterClientes()throws Exception;
}
