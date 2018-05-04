package com.dai.db;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dai.webServer.Conexao.Conexao;
import com.dai.webServer.Objects.Analytics;


public class AnalyticsDB {
	
	java.sql.Connection con;
	
	Analytics a = new Analytics();
	
    public AnalyticsDB() {
        con = Conexao.fazConexao();
    }
    
    
    public String read(String dataI, String dataF) {
    	String value = null;
    	

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
        	
            stmt = con.prepareStatement("SELECT AVG(JSON_EXTRACT(attr, '$.measurements.temperature')) FROM readings WHERE data BETWEEN ? and ? and (data is not null or data != 0)");
	     
        	stmt.setString(1, dataI);
        	stmt.setString(2, dataF);
        	
        	rs = stmt.executeQuery();
        	
        	System.out.println(rs);
        	
        	while (rs.next()) {

                System.out.println(rs.getString("AVG(JSON_EXTRACT(attr, '$.measurements.temperature'))"));
                
                value = rs.getString("AVG(JSON_EXTRACT(attr, '$.measurements.temperature'))");
		System.out.println(value);
            }
          
	   return value;
            /* return value; */
            

        } catch (SQLException ex) {
            
        } finally {
            Conexao.fechaConexao(con, stmt, rs);
            return value;
        }
		

    }
    
 public String readHumidade(String dataI, String dataF) {
    	
    	String value = null;
    	    	
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
        	
            stmt = con.prepareStatement("SELECT AVG(JSON_EXTRACT(attr, '$.measurements.humidity')) FROM readings WHERE data BETWEEN ? and ? and (data is not null or data != 0)");
	     
        	stmt.setString(1, dataI);
        	stmt.setString(2, dataF);
        	
        	rs = stmt.executeQuery();
        	
        	System.out.println(rs);
        	
        	while (rs.next()) {

                System.out.println(rs.getString("AVG(JSON_EXTRACT(attr, '$.measurements.humidity'))"));
                
                value = rs.getString("AVG(JSON_EXTRACT(attr, '$.measurements.humidity'))");
		System.out.println(value);
            }
          
	   return value;
            /* return value; */
            

        } catch (SQLException ex) {
        } finally {
            Conexao.fechaConexao(con, stmt, rs);
            return value;
        }
		

    }
    
    
    public String returnGraph(String dataI, String dataF) {
    	String value = null;
    	
 	StringBuilder mensagem = new StringBuilder();

        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
        	
            stmt = con.prepareStatement("SELECT JSON_EXTRACT(attr, '$.measurements.temperature') temp FROM readings WHERE (JSON_EXTRACT(attr, '$.measurements.temperature') != 'nan'  or JSON_EXTRACT(attr, '$.measurements.temperature') != 0.00)and data BETWEEN ? and ? and (data is not null or data != 0)");
	     
        	stmt.setString(1, dataI);
        	stmt.setString(2, dataF);
        	
        	rs = stmt.executeQuery();
        	
        	System.out.println(rs);
        	while (rs.next()) {

                System.out.println(rs.getString("temp, data"));
            }
          
	   return value;
            /* return value; */
            

        } catch (SQLException ex) {
            
        } finally {
            Conexao.fechaConexao(con, stmt, rs);
            return value;
        }
		

    }
 

}
