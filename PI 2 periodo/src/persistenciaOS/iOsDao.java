package persistenciaOS;

import java.util.ArrayList;
import classes.*;

public interface iOsDao {

    void incluir(OS objeto) throws Exception;
    void alterar(OS objeto, int id) throws Exception;
    OS consultar(int id) throws Exception;
    void excluir(int id) throws Exception;
    ArrayList<OS> obterOS() throws Exception;

}
