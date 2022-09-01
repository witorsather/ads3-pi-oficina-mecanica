
package persistenciaEstoque;
import classes.*;
import java.util.ArrayList;

public interface iEstoqueDao {
    void incluir(estoque objeto)throws Exception;
    void alterar(estoque objeto, int id) throws Exception;
    estoque consultar(int id) throws Exception;
    void excluir(int id)throws Exception;
    ArrayList<estoque> obterPecas()throws Exception;
    
}
