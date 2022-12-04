package com.example.oficinaco.jpa.jsf;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanCPFCNPJ {
    
    private String opcao;
    private String campo;

    public boolean isCPF(){
        return getOpcao()!=null && getOpcao().equals("CPF");
    }
    public boolean isCNPJ(){
        return getOpcao()!=null && getOpcao().equals("CNPJ");
    }
 
    public String getOpcao() {
        return opcao;
    }
 
    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }
 
    public String getCampo() {
        return campo;
    }
 
    public void setCampo(String campo) {
        this.campo = campo;
    }
}