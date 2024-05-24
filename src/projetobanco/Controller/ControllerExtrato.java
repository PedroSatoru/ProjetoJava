/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetobanco.DAO.UsuarioDAO;
import projetobanco.Model.Usuario;
import projetobanco.View.JanelaExtrato;

/**
 *
 * @author Pedro Satoru
 */
public class ControllerExtrato {
    private UsuarioDAO usuarioDAO;

    public ControllerExtrato(Connection conn) {
        this.usuarioDAO = new UsuarioDAO(conn);
    }

    public void mostrarExtrato(JanelaExtrato janela, Usuario usuario) {
        try {
            ResultSet rs = usuarioDAO.ConsultaExtrato(usuario.getCpf());
            StringBuilder extrato = new StringBuilder();

            while (rs.next()) {
                String dataHora = rs.getString("data_hora");
                String tipo = rs.getString("tipo");
                double valor = rs.getDouble("valor");
                double cotacao = rs.getDouble("cotacao");
                double taxa = rs.getDouble("taxa");
                double saldoReais = rs.getDouble("saldo_reais");
                double saldoBtc = rs.getDouble("saldo_btc");
                double saldoEth = rs.getDouble("saldo_eth");
                double saldoXrp = rs.getDouble("saldo_xrp");
                String moeda = rs.getString("moeda");

                extrato.append(String.format("%s   %s   %.2f  %s  CT: %.2f  TX: %.2f  REAL: %.2f  BTC: %.2f  ETH: %.2f   XRP: %.2f\n",
                        dataHora, tipo, valor, moeda, cotacao, taxa, saldoReais, saldoBtc, saldoEth, saldoXrp));
            }

            janela.getTxtExtrato1().setText(extrato.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(janela, "Erro ao consultar o extrato: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    
