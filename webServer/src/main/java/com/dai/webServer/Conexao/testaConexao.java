
package com.dai.webServer.Conexao;

import java.sql.Connection; 
import java.sql.SQLException;

import com.dai.db.AnalyticsDB;
import com.dai.webServer.Objects.Analytics;

/**
 *
 * @author Tiago Bento
 */
public class testaConexao {
    
   public static void main(String[] args) throws SQLException {
         Connection connection = new Conexao().fazConexao();
         System.out.println("Conexão aberta!");

         connection.close();
     }
    
}
