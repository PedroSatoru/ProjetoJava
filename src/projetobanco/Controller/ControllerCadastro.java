/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.Controller;

import projetobanco.DAO.Conexao;
import projetobanco.View.JanelaCriaUsuario;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetobanco.DAO.UsuarioDAO;
import projetobanco.Model.Usuario;
/**
 *
 * @author Pedro Satoru
 */
public class ControllerCadastro {
    private JanelaCriaUsuario view;

    public ControllerCadastro(JanelaCriaUsuario view) {
        this.view = view;
    }
    
    public void salvarUsuario(){
    String nome = view.getTxtEntrada_nome().getText();
    String cpf = view.getTxtEntrada_cpf().getText();
    String senha = view.getTxtEntrada_senha().getText();
    Usuario usuario= new Usuario(nome, cpf,senha);
    
    Conexao conexao = new Conexao();
    try{
        Connection conn = conexao.getConnection();
        System.out.println("conectou");
        UsuarioDAO dao = new UsuarioDAO(conn);
        dao.inserir(usuario);
        JOptionPane.showMessageDialog(view,"Usuario Cadastrado!","Aviso",JOptionPane.INFORMATION_MESSAGE );
    }catch (SQLException ex){
        JOptionPane.showMessageDialog(view, "Usuario não cadastrado!","Erro",JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
}
