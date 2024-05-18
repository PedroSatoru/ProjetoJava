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

public class ControllerSaldo {
     private Connection conn;
     private JanelaSaldo view;

    public ControllerSaldo(Connection conn) {
        this.conn = conn;
    }

    public ControllerSaldo(JanelaSaldo view) {
        this.view = view;
    }
    

    public Usuario atualizarDadosUsuario(String cpf) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        return usuarioDAO.obterUsuarioPorCpf(cpf);
    }
}

