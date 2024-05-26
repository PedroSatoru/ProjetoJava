/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobanco.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author unifnleite
 */
public class Conexao {

    /**
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        //conexão com banco de dados
        Connection conexao = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/banco2",
            "postgres", "fei");
        return conexao;
    }
}
