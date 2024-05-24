/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


import projetobanco.Model.Usuario;
public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar (Usuario usuario) throws SQLException {
        String sql = "select * from usuario where cpf = ? and senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getCpf());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    public void inserir (Usuario usuario) throws SQLException{
        String sql = "insert into usuario (nome, cpf, senha) values " 
                + "('"+usuario.getNome()+"', '"+usuario.getCpf()+"', '"+usuario.getSenha()+"')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }

    public void deposito(String cpf, double valorDeposito) throws SQLException {
        String sqlSelect = "SELECT reais FROM public.usuario WHERE cpf = ?";
        String sqlUpdate = "UPDATE public.usuario SET reais = ? WHERE cpf = ?";

        try (PreparedStatement statementSelect = conn.prepareStatement(sqlSelect)) {
            statementSelect.setString(1, cpf);
            ResultSet resultSet = statementSelect.executeQuery();

            if (resultSet.next()) {
                double valorAtual = resultSet.getDouble("reais");
                double valorNovo = valorAtual + valorDeposito;

                try (PreparedStatement statementUpdate = conn.prepareStatement(sqlUpdate)) {
                    statementUpdate.setDouble(1, valorNovo);
                    statementUpdate.setString(2, cpf);
                    statementUpdate.executeUpdate();
                }
            }
        }
    }
    public void saque(String cpf, double valorDeposito) throws SQLException {
        String sqlSelect = "SELECT reais FROM public.usuario WHERE cpf = ?";
        String sqlUpdate = "UPDATE public.usuario SET reais = ? WHERE cpf = ?";

        try (PreparedStatement statementSelect = conn.prepareStatement(sqlSelect)) {
            statementSelect.setString(1, cpf);
            ResultSet resultSet = statementSelect.executeQuery();

            if (resultSet.next()) {
                double valorAtual = resultSet.getDouble("reais");
                double valorNovo = valorAtual + valorDeposito;

                try (PreparedStatement statementUpdate = conn.prepareStatement(sqlUpdate)) {
                    statementUpdate.setDouble(1, valorNovo);
                    statementUpdate.setString(2, cpf);
                    statementUpdate.executeUpdate();
                }
            }
        }
    }
    public Usuario obterUsuarioPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM public.usuario WHERE cpf = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cpf);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String senha = resultSet.getString("senha"); // Assuming you need this, adjust if necessary
                    double reais = resultSet.getDouble("reais");
                    double btc = resultSet.getDouble("btc");
                    double eth = resultSet.getDouble("eth");
                    double rip = resultSet.getDouble("rip");
                    return new Usuario(nome, cpf, senha, reais, btc, eth, rip); // Adjust constructor as needed
                } else {
                    throw new SQLException("Usuário não encontrado");
                }
            }
        }
    }
   public ResultSet ConsultaExtrato(String cpf) throws SQLException {
        String sql = "SELECT * FROM public.transacao WHERE cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cpf);
        return statement.executeQuery();
    }
    public void adicionarCriptomoeda(Usuario usuario, String criptomoeda, double quantidade, double valor, double cotacao, double taxa) throws SQLException {
        
        String sqlUpdate = "UPDATE usuario SET " + criptomoeda.toLowerCase() + " = " + criptomoeda.toLowerCase() + " + ? WHERE cpf = ?";
        try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
            stmtUpdate.setDouble(1, quantidade);
            stmtUpdate.setString(2, usuario.getCpf());
            stmtUpdate.executeUpdate();
        }
        // Salvar a transação no extrato
        String sqlInsert = "INSERT INTO transacao (cpf, tipo, valor, cotacao, taxa, saldo_reais, saldo_btc, saldo_eth, saldo_xrp, moeda) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
            stmtInsert.setString(1, usuario.getCpf());
            stmtInsert.setString(2, "COMPRA");
            stmtInsert.setDouble(3, valor);
            stmtInsert.setDouble(4, cotacao);
            stmtInsert.setDouble(5, taxa);
            stmtInsert.setDouble(6, usuario.getReais());
            stmtInsert.setDouble(7, usuario.getBtc());
            stmtInsert.setDouble(8, usuario.getEth());
            stmtInsert.setDouble(9, usuario.getRip());
            stmtInsert.setString(10, criptomoeda);
            stmtInsert.executeUpdate();
        }
    }
}
    




