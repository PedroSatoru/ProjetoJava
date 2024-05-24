package projetobanco.Controller;

import projetobanco.DAO.Conexao;
import projetobanco.DAO.CriptomoedaDAO;
import projetobanco.DAO.UsuarioDAO;
import projetobanco.Model.Usuario;
import projetobanco.View.JanelaCompra;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class ControllerCompra {
    private JanelaCompra janelaCompra;
    private Usuario usuario;

    public ControllerCompra(JanelaCompra janelaCompra, Usuario usuario) {
        this.janelaCompra = janelaCompra;
        this.usuario = usuario;
        this.janelaCompra.getBtComprar().addActionListener(e -> comprarCriptomoeda());
    }

    private void comprarCriptomoeda() {
        String criptomoeda = null;
        double taxacao = 0;

        if (janelaCompra.getBtBit().isSelected()) {
            criptomoeda = "btc";
            taxacao = 0.02; // 2% taxa Bitcoin
        } else if (janelaCompra.getBtEth().isSelected()) {
            criptomoeda = "eth";
            taxacao = 0.01; // 1.5% taxa Etherum
        } else if (janelaCompra.getBtRip().isSelected()) {
            criptomoeda = "xrp";
            taxacao = 0.01; // 1% taxa Ripple
        }

        if (criptomoeda == null) {
            JOptionPane.showMessageDialog(janelaCompra, "Selecione uma criptomoeda para comprar", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double valorReais;
        try {
            valorReais = Double.parseDouble(janelaCompra.getTxtValor().getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(janelaCompra, "Valor inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = new Conexao().getConnection()) {
            CriptomoedaDAO criptomoedaDAO = new CriptomoedaDAO(conn);
            double valorCriptomoeda = criptomoedaDAO.getValorCriptomoeda(criptomoeda);

            if (valorCriptomoeda <= 0) {
                JOptionPane.showMessageDialog(janelaCompra, "Valor da criptomoeda inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Aplicar taxação
            double valorLiquido = valorReais - (valorReais * taxacao);
            double quantidadeComprada = valorLiquido / valorCriptomoeda;

            // Atualizar os saldos no objeto usuario (simulação, deveria buscar e atualizar saldos reais)
            double saldoReais = usuario.getReais() - valorReais;
            double saldoBtc = usuario.getBtc();
            double saldoEth = usuario.getEth();
            double saldoXrp = usuario.getRip();

            if (criptomoeda.equals("btc")) {
                saldoBtc += quantidadeComprada;
            } else if (criptomoeda.equals("eth")) {
                saldoEth += quantidadeComprada;
            } else if (criptomoeda.equals("xrp")) {
                saldoXrp += quantidadeComprada;
            }

            // Atualiza o saldo do usuário no banco de dados e salva a transação
            UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
            usuarioDAO.adicionarCriptomoeda(usuario, criptomoeda, quantidadeComprada, valorReais, valorCriptomoeda, valorReais * taxacao);

            JOptionPane.showMessageDialog(janelaCompra, "Compra realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(janelaCompra, "Erro ao realizar a compra: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}