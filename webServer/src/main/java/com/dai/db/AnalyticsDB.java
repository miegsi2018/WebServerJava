package com.dai.db;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dai.webServer.Conexao.Conexao;
import com.dai.webServer.Objects.Analytics;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;


public class AnalyticsDB {
	
	private String value;
	
	java.sql.Connection con;
	
	Analytics a = new Analytics();
	
    public AnalyticsDB() {
        con = Conexao.fazConexao();
    }
    
    
    public String read(String dataI, String dataF) {
    	

    	
    	System.out.println("****entrou");
    	

        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
        	
        	System.out.println("****try");
        	
            stmt = con.prepareStatement("select AVG(JSON_EXTRACT(attr, '$.sensor.temperature')) from readings where data between ? and ?");
            stmt.setString(1, dataI);
            stmt.setString(2, dataF);
            
            rs = stmt.executeQuery();
            
            value = rs.getString("AVG(JSON_EXTRACT(attr, '$.sensor.temperature'))");
            return value;
            

        } catch (SQLException ex) {
            
        } finally {
            Conexao.fechaConexao(con, stmt, rs);
        }
		return value;

    }
    


}
