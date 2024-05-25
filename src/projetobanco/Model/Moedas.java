/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.Model;

/**
 *
 * @author Pedro Satoru
 */
public class Moedas {

    private double valor;
    private String nome;

    /**
     *
     * @param valor
     * @param nome
     */
    public Moedas(double valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public double getValor() {
        return valor;
    }

    /**
     *
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }
}
