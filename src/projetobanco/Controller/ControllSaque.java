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
    
    private JanelaSaque view;

    public ControllSaque(JanelaSaque view) {
        this.view = view;
    }
    
    public void Saquar(Usuario usuario, double valorDeposito) throws SQLException {
    Conexao conexao = new Conexao();
    Connection conn = conexao.getConnection();

    String sqlSelect = "SELECT reais FROM public.usuario WHERE cpf = ?";
    String sqlUpdate = "UPDATE public.usuario SET reais = ? WHERE cpf = ?";
    String sqlInsertTransacao = "INSERT INTO public.transacao (cpf, data_hora, tipo, valor, cotacao, taxa, saldo_reais, saldo_btc, saldo_eth, saldo_xrp, moeda) VALUES (?, CAST(TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SS') AS TIMESTAMP), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement statementSelect = conn.prepareStatement(sqlSelect)) {
            statementSelect.setString(1, usuario.getCpf());
            ResultSet resultSet = statementSelect.executeQuery();

            if (resultSet.next()) {
                double valorAtual = resultSet.getDouble("reais");
                double valorNovo = valorAtual - valorDeposito;
                if (valorNovo < 0){
                   valorNovo=valorAtual;
                   JOptionPane.showMessageDialog(view, "Você não possui saldo suficiente para essa operação");
                }
                else if (valorNovo > 0){
                   JOptionPane.showMessageDialog(view, "Saque Concluido com sucesso\n Seu saldo atual:" + valorNovo);
                }

                try (PreparedStatement statementUpdate = conn.prepareStatement(sqlUpdate)) {
                    statementUpdate.setDouble(1, valorNovo);
                    statementUpdate.setString(2, usuario.getCpf());
                    statementUpdate.executeUpdate();
                }
                try (PreparedStatement statementInsertTransacao = conn.prepareStatement(sqlInsertTransacao)) {
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

    

