package com.dai.db;


import org.json.simple.JSONArray;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dai.webServer.Conexao.Conexao;
import com.dai.webServer.Objects.Analytics;

import org.json.simple.JSONObject;

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
        	
            stmt = con.prepareStatement("SELECT AVG(JSON_EXTRACT(attr, '$.measurements.temperature')) temp FROM readings WHERE data BETWEEN ? and ? and (data is not null or data != 0)");
	     
        	stmt.setString(1, dataI);
        	stmt.setString(2, dataF);
        	
        	rs = stmt.executeQuery();
        	
        	System.out.println(rs);
        	
        	while (rs.next()) {

                System.out.println(rs.getString("temp"));
                
                value = rs.getString("temp");
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
    
    
    public JSONObject returnGraph(String dataI, String dataF) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        JSONObject end = new JSONObject(); 
        JSONArray temp = new JSONArray();
	
        JSONArray data = new JSONArray();
       	Integer i = 0; 

        try {
        	
            stmt = con.prepareStatement("SELECT JSON_EXTRACT(attr, '$.measurements.temperature') temp, data data FROM readings WHERE (JSON_EXTRACT(attr, '$.measurements.temperature') != 'nan'  or JSON_EXTRACT(attr, '$.measurements.temperature') != 0.00)and data BETWEEN ? and ? and (data is not null or data != 0)");
	     
        	stmt.setString(1, dataI);
        	stmt.setString(2, dataF);
        	
        	rs = stmt.executeQuery();
        	
        	while (rs.next()) {
              		temp.add(i, rs.getString("temp"));

              		data.add(i, rs.getString("data"));
			System.out.println(rs.getString("temp"));
            }
        end.put("temp" , temp);	

        end.put("data" , data);	
	    //return onalue;
            

        } catch (SQLException ex) {
            
        } finally {
            Conexao.fechaConexao(con, stmt, rs);
            
            return end;
        }
		
    }


}
