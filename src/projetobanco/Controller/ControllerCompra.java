package projetobanco.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetobanco.DAO.Conexao;
import projetobanco.Model.Usuario;
import projetobanco.View.JanelaCompra;

public class ControllerCompra {

    private JanelaCompra view;
    private Usuario usuario;

    public ControllerCompra(JanelaCompra view, Usuario usuario) {
        this.view = view;
        this.usuario = usuario;
    }

    public void comprarCriptomoeda(String criptomoeda, double valorReais) throws SQLException {
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        String sqlSelectSaldo = "SELECT reais, btc, eth, rip FROM public.usuario WHERE cpf = ?";
        String sqlUpdateSaldo = "UPDATE public.usuario SET reais = ?, btc = ?, eth = ?, rip = ? WHERE cpf = ?";
        String sqlSelectCotacao = "SELECT btc, eth, xrp FROM public.criptomoedas WHERE id = 1"; // Assume-se que as cotações estão no registro com id=1
        String sqlInsertTransacao = "INSERT INTO public.transacao (cpf, data_hora, tipo, valor, cotacao, taxa, saldo_reais, saldo_btc, saldo_eth, saldo_xrp, moeda) VALUES (?, CAST(TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SS') AS TIMESTAMP), ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        double cotacao = 0.0;
        double taxa = 0.00; 

        // Obter cotação da criptomoeda
        try (PreparedStatement statementSelectCotacao = conn.prepareStatement(sqlSelectCotacao)) {
            ResultSet resultSetCotacao = statementSelectCotacao.executeQuery();

            if (resultSetCotacao.next()) {
                switch (criptomoeda) {
                    case "Bitcoin":
                        cotacao = resultSetCotacao.getDouble("btc");
                        taxa = 0.02;
                        break;
                    case "Etherum":
                        cotacao = resultSetCotacao.getDouble("eth");
                        taxa= 0.01;
                        break;
                    case "Ripple":
                        cotacao = resultSetCotacao.getDouble("xrp");
                        taxa = 0.01;
                        break;
                    default:
                        JOptionPane.showMessageDialog(view, "Criptomoeda não encontrada.");
                        return;
                }
            }
        }

        double quantidadeComprada = valorReais / cotacao * (1 - taxa);

        try (PreparedStatement statementSelectSaldo = conn.prepareStatement(sqlSelectSaldo)) {
            statementSelectSaldo.setString(1, usuario.getCpf());
            ResultSet resultSet = statementSelectSaldo.executeQuery();

            if (resultSet.next()) {
                double saldoReaisAtual = resultSet.getDouble("reais");
                double saldoBTC = resultSet.getDouble("btc");
                double saldoETH = resultSet.getDouble("eth");
                double saldoXRP = resultSet.getDouble("rip");

                if (saldoReaisAtual < valorReais) {
                    JOptionPane.showMessageDialog(view, "Você não possui saldo suficiente para essa operação");
                    return;
                }

                double novoSaldoReais = saldoReaisAtual - valorReais;

                // Atualizar saldos de criptomoedas
                switch (criptomoeda) {
                    case "Bitcoin":
                        saldoBTC += quantidadeComprada;
                        break;
                    case "Etherum":
                        saldoETH += quantidadeComprada;
                        break;
                    case "Ripple":
                        saldoXRP += quantidadeComprada;
                        break;
                }

                try (PreparedStatement statementUpdateSaldo = conn.prepareStatement(sqlUpdateSaldo)) {
                    statementUpdateSaldo.setDouble(1, novoSaldoReais);
                    statementUpdateSaldo.setDouble(2, saldoBTC);
                    statementUpdateSaldo.setDouble(3, saldoETH);
                    statementUpdateSaldo.setDouble(4, saldoXRP);
                    statementUpdateSaldo.setString(5, usuario.getCpf());
                    statementUpdateSaldo.executeUpdate();
                }

                try (PreparedStatement statementInsertTransacao = conn.prepareStatement(sqlInsertTransacao)) {
                    statementInsertTransacao.setString(1, usuario.getCpf());
                    statementInsertTransacao.setString(2, "+");
                    statementInsertTransacao.setDouble(3, valorReais);
                    statementInsertTransacao.setDouble(4, cotacao);
                    statementInsertTransacao.setDouble(5, taxa);
                    statementInsertTransacao.setDouble(6, novoSaldoReais);
                    statementInsertTransacao.setDouble(7, saldoBTC);
                    statementInsertTransacao.setDouble(8, saldoETH);
                    statementInsertTransacao.setDouble(9, saldoXRP);
                    statementInsertTransacao.setString(10, criptomoeda);
                    statementInsertTransacao.executeUpdate();
                }

                JOptionPane.showMessageDialog(view, "Compra realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } finally {
            conn.close();
        }
    }
}
