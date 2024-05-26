/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetobanco.DAO.Conexao;
import projetobanco.Model.Usuario;
import projetobanco.View.JanelaSaque;

/**
 *
 * @author Pedro Satoru
 */
public class ControllSaque {
    //Comentarios dessa pagina se aplicam a pagina de Deposito
    private JanelaSaque view;

    /**
     *
     * @param view
     */
    public ControllSaque(JanelaSaque view) /* recebe como parametro a janela que ira controlar */{
        this.view = view;
    }
    
    /**
     *
     * @param usuario
     * @param valorDeposito
     * @throws SQLException
     */
    public void Saquar(Usuario usuario, double valorDeposito) throws SQLException {
    Conexao conexao = new Conexao();//estabelece conexão com o banco de dados
    Connection conn = conexao.getConnection();

    //comandos sql para utilização do banco de dados
    String sqlSelect = "SELECT reais FROM public.usuario WHERE cpf = ?";//pegar informações pelo cpf especifico
    String sqlUpdate = "UPDATE public.usuario SET reais = ? WHERE cpf = ?";//atualizar informações do usuario pelo cpf
    //adicionar uma linha na tabela de xtrato, com todas informações da operação
    String sqlInsertTransacao = "INSERT INTO public.transacao (cpf, data_hora, tipo, valor, cotacao, taxa, saldo_reais, saldo_btc, saldo_eth, saldo_xrp, moeda) VALUES (?, CAST(TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SS') AS TIMESTAMP), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement statementSelect = conn.prepareStatement(sqlSelect)) {//pegar informação pelo cpf e recebr resposta se o cpf existe
            statementSelect.setString(1, usuario.getCpf());
            ResultSet resultSet = statementSelect.executeQuery();

            if (resultSet.next()) {//caso a resposta seja verdadeira iniciar a operação
                double valorAtual = resultSet.getDouble("reais");//recebe o valor de reais do banco de dados
                double valorNovo = valorAtual - valorDeposito;//realiza a operação
                if (valorNovo < 0){//condição para caso a operação seja impossivel
                   valorNovo=valorAtual;
                   JOptionPane.showMessageDialog(view, "Você não possui saldo suficiente para essa operação");
                   return;
                }
                else if (valorNovo > 0){ //mostra ao usuario o saldo atual
                   JOptionPane.showMessageDialog(view, "Saque Concluido com sucesso\n Seu saldo atual:" + valorNovo);
                }
                //atualiza o saldo do usuario no banco de dados
                try (PreparedStatement statementUpdate = conn.prepareStatement(sqlUpdate)) { 
                    statementUpdate.setDouble(1, valorNovo);
                    statementUpdate.setString(2, usuario.getCpf());
                    statementUpdate.executeUpdate();
                }
                try (PreparedStatement statementInsertTransacao = conn.prepareStatement(sqlInsertTransacao)) { //adiciona a linha de extrato
                    statementInsertTransacao.setString(1, usuario.getCpf());
                    statementInsertTransacao.setString(2, "-");
                    statementInsertTransacao.setDouble(3, valorDeposito);
                    statementInsertTransacao.setDouble(4, 0.0); 
                    statementInsertTransacao.setDouble(5, 0.0); 
                    statementInsertTransacao.setDouble(6, valorNovo);
                    statementInsertTransacao.setDouble(7, usuario.getBtc());
                    statementInsertTransacao.setDouble(8, usuario.getEth());
                    statementInsertTransacao.setDouble(9, usuario.getRip());
                    statementInsertTransacao.setString(10, "REAL");
                    statementInsertTransacao.executeUpdate();
                }
            }
        } finally {
            conn.close();
        }
    }
}

    

