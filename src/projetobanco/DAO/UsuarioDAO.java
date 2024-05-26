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

/**
 *
 * @author Pedro Satoru
 */
public class UsuarioDAO {
    private Connection conn;

    /**
     *
     * @param conn
     */
    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    /**
     *
     * @param usuario
     * @return
     * @throws SQLException
     */
    public ResultSet consultar (Usuario usuario) throws SQLException {
        //verificar se o usuario existe na tabela usuarios pelo cpf e senha
        String sql = "select * from usuario where cpf = ? and senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getCpf());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }

    /**
     *
     * @param usuario
     * @throws SQLException
     */
    public void inserir (Usuario usuario) throws SQLException{
        //adicionar o usuario a tabela de usuarios
        String sql = "insert into usuario (nome, cpf, senha) values " 
                + "('"+usuario.getNome()+"', '"+usuario.getCpf()+"', '"+usuario.getSenha()+"')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }

    /**
     *
     * @param cpf
     * @param valorDeposito
     * @throws SQLException
     */
    public void deposito(String cpf, double valorDeposito) throws SQLException {
        //função de depositar
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

    /**
     *
     * @param cpf
     * @param valorDeposito
     * @throws SQLException
     */
    public void saque(String cpf, double valorDeposito) throws SQLException {
        //função de saque
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

    /**
     *
     * @param cpf
     * @return
     * @throws SQLException
     */
    public Usuario obterUsuarioPorCpf(String cpf) throws SQLException {
        //receber o usuario pelo cpf
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

    /**
     *
     * @param cpf
     * @return
     * @throws SQLException
     */
    public ResultSet ConsultaExtrato(String cpf) throws SQLException {
        //procurar pelas transaçções feitas por um cpf na tabela de extrato
        String sql = "SELECT * FROM public.transacao WHERE cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cpf);
        return statement.executeQuery();
    }

    /**
     *
     * @param usuario
     * @param criptomoeda
     * @param quantidade
     * @param valor
     * @param cotacao
     * @param taxa
     * @throws SQLException
     */
    public void adicionarCriptomoeda(Usuario usuario, String criptomoeda, double quantidade, double valor, double cotacao, double taxa) throws SQLException {
        //atualiza a quantidade de criptomedas do usuario na tabela usuario
        String sqlUpdate = "UPDATE usuario SET " + criptomoeda.toLowerCase() + " = " + criptomoeda.toLowerCase() + " + ? WHERE cpf = ?";
        try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
            stmtUpdate.setDouble(1, quantidade);
            stmtUpdate.setString(2, usuario.getCpf());
            stmtUpdate.executeUpdate();
        }
        //salva a transação no extrato
    String sqlInsert = "INSERT INTO public.transacao (cpf, data_hora, tipo, valor, cotacao, taxa, saldo_reais, saldo_btc, saldo_eth, saldo_xrp, moeda) VALUES (?, CAST(TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SS') AS TIMESTAMP), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
            stmtInsert.setString(1, usuario.getCpf());
            stmtInsert.setString(2, "+");
            stmtInsert.setDouble(3, 1);
            stmtInsert.setDouble(4, 0);
            stmtInsert.setDouble(5, 0);
            stmtInsert.setDouble(6, usuario.getReais());
            stmtInsert.setDouble(7, usuario.getBtc());
            stmtInsert.setDouble(8, usuario.getEth());
            stmtInsert.setDouble(9, usuario.getRip());
            stmtInsert.setString(10, criptomoeda);
            stmtInsert.executeUpdate();
        }
    }
}
    




