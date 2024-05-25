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

    /**
     *
     * @param nome
     * @param cpf
     * @param senha
     */
    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    /**
     *
     * @param nome
     * @param cpf
     * @param senha
     * @param reais
     * @param btc
     * @param eth
     * @param rip
     */
    public Usuario(String nome, String cpf, String senha, Double reais, Double btc, Double eth, Double rip) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.reais = reais;
        this.btc = btc;
        this.eth = eth;
        this.rip = rip;
    }
    
    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getCpf() {
        return cpf;
    }

    /**
     *
     * @param cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     *
     * @return
     */
    public Double getReais() {
        return reais;
    }

    /**
     *
     * @param reais
     */
    public void setReais(Double reais) {
        this.reais = reais;
    }

    /**
     *
     * @return
     */
    public Double getBtc() {
        return btc;
    }

    /**
     *
     * @param btc
     */
    public void setBtc(Double btc) {
        this.btc = btc;
    }

    /**
     *
     * @return
     */
    public Double getEth() {
        return eth;
    }

    /**
     *
     * @param eth
     */
    public void setEth(Double eth) {
        this.eth = eth;
    }

    /**
     *
     * @return
     */
    public Double getRip() {
        return rip;
    }

    /**
     *
     * @param rip
     */
    public void setRip(Double rip) {
        this.rip = rip;
    }
     
     
}
