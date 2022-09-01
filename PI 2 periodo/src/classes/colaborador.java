package classes;

import enumeradores.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class colaborador {

    private String nome;
    private telefone telefone;
    private int ID;
    private endereco endereco;
    private String email;
    private String CPF;
    private Date dataNascimento;
    private double salarioMensal;
    private double salarioHora;
    private String especialidade;

    public colaborador() {
    }

    public colaborador(String nome, telefone telefone, int ID, endereco endereco, String email, String CPF,
            Date dataNascimento, double salarioMensal, double salarioHora, String especialidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.ID = ID;
        this.endereco = endereco;
        this.email = email;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.salarioMensal = salarioMensal;
        this.salarioHora = salarioHora;
        this.especialidade = especialidade;
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

    public String getCPF() {
        return CPF;
    }

    public boolean setCPF(String CPF) {
        String cpf;
        if (CPF.length() == 14) {
            cpf = desformatoCPF(CPF);
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
                    this.CPF = CPF;
                    return (true);
                } else {
                    return (false);
                }
            } catch (InputMismatchException erro) {
                return (false);
            }
        }
        this.CPF = CPF;
        return true;
    }

    public String desformatoCPF(String CPF) {
        CPF = CPF.replace(".", "");
        CPF = CPF.replace("-", "");
        return CPF;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = dateFormat.parse(dataNascimento);
        this.dataNascimento = dataFormatada;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return nome + ";" + telefone + ";" + ID + ";"
                + endereco + ";" + email + ";" + CPF + ";"
                + new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento) + ";"
                + salarioMensal + ";" + salarioHora + ";" + especialidade;
    }
}
