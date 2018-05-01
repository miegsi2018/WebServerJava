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
    
    
    
    public void read(Analytics analytics) {
    	
    	System.out.println("****entrou");
    	

        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
        	
        	System.out.println("****try");
        	
            stmt = con.prepareStatement("select AVG(JSON_EXTRACT(attr, '$.sensor.temperature')) from readings where data between ? and ?");
            stmt.setTimestamp(1, analytics.getDataI());
            stmt.setTimestamp(2, analytics.getDataF());
            
            rs = stmt.executeQuery();
            

            while (rs.next()) {
            	
            	Analytics a= new Analytics();
            	
            	a.setTemperatura(rs.getInt("AVG(JSON_EXTRACT(attr, '$.sensor.temperature'))"));
            	
            }
            

        } catch (SQLException ex) {
            
        } finally {
            Conexao.fechaConexao(con, stmt, rs);
        }

    }
    


}
