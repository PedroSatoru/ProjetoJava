/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.DAO;

/**
 *
 * @author Pedro Satoru
 */
public class Btc  extends Moedas{
  private double cotacaoReal;

    public Btc(double cotacaoReal, double valor, String nome) {
        super(valor, nome);
        this.cotacaoReal = cotacaoReal;
    }
  @Override
    public double getValor() {
        return super.getValor(); // Acessando o valor através do método
    }

  @Override
    public void setValor(double valor) {
        super.setValor(valor); // Alterando o valor através do método
    }
    public double getCotacaoReal() {
        return cotacaoReal;
    }

    public void setCotacaoReal(double cotacaoReal) {
        this.cotacaoReal = cotacaoReal;
    }

    public double converterParaReal() {
        return getValor() * cotacaoReal;
    }
}
