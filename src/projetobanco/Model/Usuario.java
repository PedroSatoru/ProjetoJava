/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.Model;

/**
 *
 * @author Pedro Satoru
 */
public class Usuario {
     private String nome, cpf, senha;
     private Double reais, btc, eth, rip;

    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Usuario(String nome, String cpf, String senha, Double reais, Double btc, Double eth, Double rip) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.reais = reais;
        this.btc = btc;
        this.eth = eth;
        this.rip = rip;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getReais() {
        return reais;
    }

    public void setReais(Double reais) {
        this.reais = reais;
    }

    public Double getBtc() {
        return btc;
    }

    public void setBtc(Double btc) {
        this.btc = btc;
    }

    public Double getEth() {
        return eth;
    }

    public void setEth(Double eth) {
        this.eth = eth;
    }

    public Double getRip() {
        return rip;
    }

    public void setRip(Double rip) {
        this.rip = rip;
    }
     
     
}
