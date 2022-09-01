package classes;

import enumeradores.*;
import classes.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JFormattedTextField;

public class cliente {

    private String nome;
    private telefone telefone;
    private int ID;
    private endereco endereco;
    private String email;
    private tipoCliente tipoCliente;
    private String CPF_CNPJ;
    private Date dataNascimento;
    private String razaoSocial;

    public cliente() {
    }

    public cliente(String nome, telefone telefone, int ID, endereco endereco, String email, tipoCliente tipoCliente, String CPF_CNPJ, Date dataNascimento, String razaoSocial) {
        this.nome = nome;
        this.telefone = telefone;
        this.ID = ID;
        this.endereco = endereco;
        this.email = email;
        this.tipoCliente = tipoCliente;
        this.CPF_CNPJ = CPF_CNPJ;
        this.dataNascimento = dataNascimento;
        this.razaoSocial = razaoSocial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(telefone telefone) {
        this.telefone = telefone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public tipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(tipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public boolean setCPF_CNPJ(String CPF_CNPJ) throws Exception {
        String cpf;
        String cnpj;

        if (CPF_CNPJ.length() == 14) {
            cpf = desformatoCPF(CPF_CNPJ);
            if (cpf.equals("00000000000")
                    || cpf.equals("11111111111")
                    || cpf.equals("22222222222") || cpf.equals("33333333333")
                    || cpf.equals("44444444444") || cpf.equals("55555555555")
                    || cpf.equals("66666666666") || cpf.equals("77777777777")
                    || cpf.equals("88888888888") || cpf.equals("99999999999")) {
                return (false);
            }
            char dig10, dig11;
            int sm, i, r, num, peso;
            try {
                sm = 0;
                peso = 10;
                for (i = 0; i < 9; i++) {
                    num = (int) (cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }
                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11)) {
                    dig10 = '0';
                } else {
                    dig10 = (char) (r + 48);
                }
                sm = 0;
                peso = 11;
                for (i = 0; i < 10; i++) {
                    num = (int) (cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }
                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11)) {
                    dig11 = '0';
                } else {
                    dig11 = (char) (r + 48);
                }
                if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                    this.CPF_CNPJ = CPF_CNPJ;
                    return (true);
                } else {
                    return (false);
                }
            } catch (InputMismatchException erro) {
                return (false);
            }
        } else if (CPF_CNPJ.length() == 18) {
            cnpj = desformatoCNPJ(CPF_CNPJ);
            if (cnpj.equals("00000000000000")
                    || cnpj.equals("11111111111111")
                    || cnpj.equals("22222222222222") || cnpj.equals("33333333333333")
                    || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
                    || cnpj.equals("66666666666666") || cnpj.equals("77777777777777")
                    || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
                return (false);
            }
            char dig13, dig14;
            int sm, i, r, num, peso;
            try {
                sm = 0;
                peso = 2;
                for (i = 11; i >= 0; i--) {
                    num = (int) (cnpj.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso + 1;
                    if (peso == 10) {
                        peso = 2;
                    }
                }
                r = sm % 11;
                if ((r == 0) || (r == 1)) {
                    dig13 = '0';
                } else {
                    dig13 = (char) ((11 - r) + 48);
                }
                sm = 0;
                peso = 2;
                for (i = 12; i >= 0; i--) {
                    num = (int) (cnpj.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso + 1;
                    if (peso == 10) {
                        peso = 2;
                    }
                }

                r = sm % 11;
                if ((r == 0) || (r == 1)) {
                    dig14 = '0';
                } else {
                    dig14 = (char) ((11 - r) + 48);
                }
                if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
                    this.CPF_CNPJ = CPF_CNPJ;
                    return (true);
                } else {
                    return (false);
                }
            } catch (InputMismatchException erro) {
                return (false);
            }
        }
        if (CPF_CNPJ.length() != 14 && CPF_CNPJ.length() != 18) {
            return false;
        }
        this.CPF_CNPJ = CPF_CNPJ;
        return true;
    }

    public String desformatoCPF(String CPF) {
        CPF = CPF.replace(".", "");
        CPF = CPF.replace("-", "");
        return CPF;
    }

    public String desformatoCNPJ(String CNPJ) {
        CNPJ = CNPJ.replace(".", "");
        CNPJ = CNPJ.replace("/", "");
        CNPJ = CNPJ.replace("-", "");
        return CNPJ;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) throws Exception {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = dateFormat.parse(dataNascimento);

        this.dataNascimento = dataFormatada;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String toString() {
        return nome + ";" + telefone + ";" + ID + ";" + endereco + ";" + email + ";" + tipoCliente + ";" + CPF_CNPJ + ";" + new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento) + ";" + razaoSocial;
    }

}
