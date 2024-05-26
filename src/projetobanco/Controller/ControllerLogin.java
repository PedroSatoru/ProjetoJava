/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.Controller;


import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetobanco.DAO.Conexao;
import projetobanco.DAO.UsuarioDAO;
import projetobanco.Model.Usuario;
import projetobanco.View.JanelaLogin;
import projetobanco.View.JanelaMenu;

/**
 *
 * @author Pedro Satoru
 */
public class ControllerLogin {
    private JanelaLogin view;

    /**
     *
     * @param view
     */
    public ControllerLogin(JanelaLogin view) {
        this.view = view;
    }
    
    /**
     *
     */
    public void loginUsuario(){
        //recebe os valores da janela
        Usuario usuario = new Usuario(null, view.getTxtCpf().getText(),
                                            view.getTxtSenha().getText());
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            //verifica a função "consultar" da usuarioDAO
            ResultSet res = dao.consultar(usuario);
            if (res.next()){
                //caso o usuario exista, recebera as informações dele, e passara essas informações ao model usuario
                JOptionPane.showMessageDialog(view, "Login feito!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                Double real = res.getDouble("reais");
                Double btc = res.getDouble("btc");
                Double eth = res.getDouble("eth");
                Double rip = res.getDouble("rip");
                JanelaMenu viewUsuario = new JanelaMenu(new Usuario(nome,cpf,senha,real,btc,eth,rip));
                viewUsuario.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(view, "Login não efetuado!");
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão!");
        }
    }
    
}
