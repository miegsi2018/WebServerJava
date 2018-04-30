
package com.dai.webServer.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago Bento
 */
public class Conexao {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://darkredman-casa.dyndns.org:3306/dwpt_dai";
    private static final String USER = "dai";
    private static final String PASS = "mypass";
    
  
    // FAZ CONEXAO
    public static Connection fazConexao(){
        
        try {
            
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("nao entra.");
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }
    
    
    //FECHA CONEXAO
    public static void fechaConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
  //FECHA CONEXAO
    public static void fechaConexao(Connection con, PreparedStatement stmt) {

        fechaConexao(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
  //FECHA CONEXAO
    public static void fechaConexao(Connection con, PreparedStatement stmt, ResultSet rs) {

        fechaConexao(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}