/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.Controller;

import java.sql.Connection;
import java.sql.SQLException;
import projetobanco.DAO.UsuarioDAO;
import projetobanco.Model.Usuario;
import projetobanco.View.JanelaSaldo;
import projetobanco.View.JanelaSenhaSaque;

/**
 *
 * @author Pedro Satoru
 */
public class ControllerSaldo {
     private Connection conn;
     private JanelaSenhaSaque view;

    /**
     *
     * @param conn
     */
    public ControllerSaldo(Connection conn) {
        this.conn = conn;
    }

    /**
     *
     * @param view
     */
    public ControllerSaldo(JanelaSenhaSaque view) {
        this.view = view;
    }
    
    /**
     *
     * @param cpf
     * @return
     * @throws SQLException
     */
    public Usuario atualizarDadosUsuario(String cpf) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        return usuarioDAO.obterUsuarioPorCpf(cpf);
    }
    
    
    
}

