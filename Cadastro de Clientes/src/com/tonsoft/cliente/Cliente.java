package com.tonsoft.cliente;

public class Cliente {
    private int id;
    private String nome;
    private String celular;
    private String email;
    private String cidade;
    private String cpf;
    private String rg;
    private String dataNasc;
    private String telefone;
    private String rua;
    private String bairro;
    private String comp;
    private String numero;
    private String uf;

    public Cliente(String nome, String celular, String email, String cidade, String cpf,
                   String rg, String dataNasc, String telefone, String rua,
                   String bairro, String comp, String numero, String uf) {
    	
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.cidade = cidade;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.comp = comp;
        this.numero = numero;
        this.uf = uf;
    }

    public Cliente() {}

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
