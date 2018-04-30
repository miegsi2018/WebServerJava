package com.dai.db;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dai.webServer.Conexao.Conexao;
import com.dai.webServer.Objects.Analytics;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;


public class AnalyticsDB {
	
	java.sql.Connection con;
	
	Analytics a = new Analytics();
	
    public AnalyticsDB() {
        con = Conexao.fazConexao();
    }
    
    
    
    public void read() {
    	

        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
        	
            stmt = con.prepareStatement("SELECT * FROM readings WHERE data = ?");
            stmt.setString(1, "2018-04-29 21:48:37");
            
            rs = stmt.executeQuery();
            

            while (rs.next()) {
            	
            	Analytics analytics = new Analytics();
            	
            	analytics.setTemperatura("22.5");
            	
                 
            	System.out.println(rs.getString("attr"));
            	System.out.println(rs.getString("data"));
            }
            
            

        } catch (SQLException ex) {
            
        } finally {
            Conexao.fechaConexao(con, stmt, rs);
        }

    }
    


}
