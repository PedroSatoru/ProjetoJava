
package projetobanco.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author Pedro Satoru
 */
public class CriptomoedaDAO {
    private Connection conn;

    /**
     *
     * @param conn
     */
    public CriptomoedaDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     *
     * @throws SQLException
     */
    public void atualizarValoresCriptomoedas() throws SQLException {
        String sqlSelect = "SELECT btc, eth, xrp FROM criptomoedas";
        String sqlUpdate = "UPDATE criptomoedas SET btc = ?, eth = ?, xrp = ?";

        Random rand = new Random();
        double fator = 0.05; // 5%

        try (PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
             ResultSet rs = psSelect.executeQuery()) {
            
            if (rs.next()) {
                double btc = rs.getDouble("btc");
                double eth = rs.getDouble("eth");
                double xrp = rs.getDouble("xrp");

                btc += btc * (rand.nextDouble() * 2 * fator - fator);
                eth += eth * (rand.nextDouble() * 2 * fator - fator);
                xrp += xrp * (rand.nextDouble() * 2 * fator - fator);

                try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                    psUpdate.setDouble(1, btc);
                    psUpdate.setDouble(2, eth);
                    psUpdate.setDouble(3, xrp);
                    psUpdate.executeUpdate();
                }
            }
        }
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public ResultSet obterUltimosValores() throws SQLException {
        String sql = "SELECT btc, eth, xrp FROM criptomoedas";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }
    
    /**
     *
     * @param criptomoeda
     * @return
     * @throws SQLException
     */
    public double getValorCriptomoeda(String criptomoeda) throws SQLException {
        String sql = "SELECT valor FROM criptomoedas WHERE nome = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, criptomoeda);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("valor");
                } else {
                    throw new SQLException("Criptomoeda não encontrada");
                }
            }
        }
    }
}
