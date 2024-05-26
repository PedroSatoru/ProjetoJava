package projetobanco.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import projetobanco.DAO.Conexao;
import projetobanco.DAO.CriptomoedaDAO;
import projetobanco.View.JanelaMenu;

/**
 *
 * @author Pedro Satoru
 */
public class ControllerMenu {
    private JanelaMenu view;

    /**
     *
     * @param view
     */
    public ControllerMenu(JanelaMenu view) {
        this.view = view;
    }

    /**
     *
     */
    public void abrirMenu() {
        //chama a função de atualizar
        atualizarValoresCriptomoedas();
    }

    /**
     *
     */
    public void atualizarValoresCriptomoedas() {
        //chama a função de atuapizar da criptomoedasDAO
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            CriptomoedaDAO criptomoedaDAO = new CriptomoedaDAO(conn);
            criptomoedaDAO.atualizarValoresCriptomoedas();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}