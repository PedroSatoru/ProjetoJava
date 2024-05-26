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

    /**
     *
     * @param view
     */
    public ControllerCadastro(JanelaCriaUsuario view) {
        this.view = view;
    }
    
    /**
     *
     */
    public void salvarUsuario() {
        //receber as informações da janela
        String nome = view.getTxtEntrada_nome().getText();
        String cpf = view.getTxtEntrada_cpf().getText();
        String senha = view.getTxtEntrada_senha().getText();

        if (!isCpfValid(cpf)) {
            //informar que o cpf é invalido
            JOptionPane.showMessageDialog(view, "CPF inválido! Certifique-se de que contém exatamente 11 dígitos e não possui caracteres especiais.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
         if (!isSenhaValid(senha)) {
             //informar que a senha é invalida
            JOptionPane.showMessageDialog(view, "Senha inválida! A senha deve ser numérica e conter exatamente 6 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = new Usuario(nome, cpf, senha);

        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            System.out.println("conectou");
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir(usuario);//passa os dados a função inserir da DAO
            JOptionPane.showMessageDialog(view, "Usuário cadastrado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Usuário não cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private boolean isCpfValid(String cpf) {
        //remove caracteres especiais
        String cpfClean = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        return cpfClean.length() == 11;
        
    }
    
    private boolean isSenhaValid(String senha) {
        //verifica se a senha contém exatamente 6 dígitos numéricos
        return senha.matches("\\d{6}");
    }
}
