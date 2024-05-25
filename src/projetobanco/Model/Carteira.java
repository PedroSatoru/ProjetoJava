/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.Model;

/**
 *
 * @author Pedro Satoru
 */
public class Carteira extends Usuario {
    
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
    public Carteira(String nome, String cpf, String senha, Double reais, Double btc, Double eth, Double rip) {
        super(nome, cpf, senha, reais, btc, eth, rip);
    }
    
}
