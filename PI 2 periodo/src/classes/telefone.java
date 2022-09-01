package classes;

import enumeradores.tiposTelefone;
import javax.swing.JFormattedTextField;

public class telefone {

    String telefone;
    private tiposTelefone tipotelefone;

    public telefone() {
    }

    public telefone(String telefone, tiposTelefone tipotelefone) {
        this.telefone = telefone;
        this.tipotelefone = tipotelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {

        this.telefone = telefone;
    }

    public tiposTelefone getTipo() {
        return tipotelefone;
    }

    public void setTipo(tiposTelefone tipotelefone) {

        this.tipotelefone = tipotelefone;
    }

    @Override
    public String toString() {
        return tipotelefone + "," + telefone;
    }

   

}
