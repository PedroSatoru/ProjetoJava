/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.Model;

/**
 *
 * @author Pedro Satoru
 */
public class Btc  extends Moedas{
  private double cotacaoReal;

    /**
     *
     * @param cotacaoReal
     * @param valor
     * @param nome
     */
    public Btc(double cotacaoReal, double valor, String nome) {
        super(valor, nome);
        this.cotacaoReal = cotacaoReal;
    }

    /**
     *
     * @return
     */
    @Override
    public double getValor() {
        return super.getValor(); // Acessando o valor através do método
    }

    /**
     *
     * @param valor
     */
    @Override
    public void setValor(double valor) {
        super.setValor(valor); // Alterando o valor através do método
    }

    /**
     *
     * @return
     */
    public double getCotacaoReal() {
        return cotacaoReal;
    }

    /**
     *
     * @param cotacaoReal
     */
    public void setCotacaoReal(double cotacaoReal) {
        this.cotacaoReal = cotacaoReal;
    }

    /**
     *
     * @return
     */
    public double converterParaReal() {
        return getValor() * cotacaoReal;
    }
}
