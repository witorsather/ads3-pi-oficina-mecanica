package persistenciaServicos;
import classes.servicos;
import java.util.ArrayList;

public interface iServicosDao {
    void incluir(servicos objeto)throws Exception;
    void alterar(servicos objeto, int id) throws Exception;
    servicos consultar(int id) throws Exception;
    void excluir(int id)throws Exception;
    ArrayList<servicos> obterServicos () throws Exception;
    
}