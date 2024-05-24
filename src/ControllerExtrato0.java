import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetobanco.DAO.UsuarioDAO;
import projetobanco.Model.Usuario;
import projetobanco.View.JanelaExtrato;

public class ControllerExtrato0 {
    private UsuarioDAO usuarioDAO;

    public ControllerExtrato0(Connection conn) {
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

                extrato.append(String.format("%s %s %.2f CT: %.2f TX: %.2f REAL: %.2f BTC: %.8f ETH: %.8f XRP: %.8f\n",
                        dataHora, tipo, valor, cotacao, taxa, saldoReais, saldoBtc, saldoEth, saldoXrp));
            }

            janela.getTxtExtrato1().setText(extrato.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(janela, "Erro ao consultar o extrato: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    
