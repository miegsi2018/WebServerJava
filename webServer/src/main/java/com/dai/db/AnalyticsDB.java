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
    
    public String approve(String message, String topic){
    	String value = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
        	
            stmt = con.prepareStatement("SELECT email from v_contas where sensor_id =? and id_card = ?");
	     
        	stmt.setString(1, topic);

        	stmt.setString(2, message);

        	rs = stmt.executeQuery();
        	
        	System.out.println(rs);
        	
        	while (rs.next()) {

                System.out.println(rs.getString("email"));
                
                value = rs.getString("email");
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
    public String read(String device, String dataI, String dataF) {
    	String value = null;
    	

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
        	
            stmt = con.prepareStatement("SELECT AVG(JSON_EXTRACT(attr, '$.measurements.temperature')) temp FROM readings WHERE JSON_EXTRACT(attr, '$.device.deviceID') = ? and  data BETWEEN ? and ? and (data is not null or data != 0)");
	     
        	stmt.setString(1, device);
        	stmt.setString(2, dataI);
        	stmt.setString(3, dataF);


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
    
 public String readHumidade(String device, String dataI, String dataF) {
    	
    	String value = null;
    	    	
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
        	
            stmt = con.prepareStatement("SELECT AVG(JSON_EXTRACT(attr, '$.measurements.humidity')) FROM readings WHERE  JSON_EXTRACT(attr, '$.device.deviceID') = ?  and data BETWEEN ? and ? and (data is not null or data != 0)");
	     
        	stmt.setString(1, device);
        	stmt.setString(2, dataI);
        	stmt.setString(3, dataF);

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
    
    
    public JSONObject returnGraph(String device, String dataI, String dataF) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        JSONObject end = new JSONObject(); 
        JSONArray temp = new JSONArray();
	
        JSONArray data = new JSONArray();
       	Integer i = 0; 

        try {
        	
            stmt = con.prepareStatement("SELECT JSON_EXTRACT(attr, '$.measurements.temperature') temp, data data FROM readings WHERE JSON_EXTRACT(attr, '$.device.deviceID') = ? and (JSON_EXTRACT(attr, '$.measurements.temperature') != 'nan'  or JSON_EXTRACT(attr, '$.measurements.temperature') != 0.00)and data BETWEEN ? and ? and (data is not null or data != 0)");
	     
        	stmt.setString(1, device);
        	stmt.setString(2, dataI);
        	stmt.setString(3, dataF);
        	
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
    
    //Gravar entradas em casa na BD
    
    public void insertDB(String tag , String outcome){
		
	    PreparedStatement stmt = null;
		
		    try {
		        stmt = con.prepareStatement("INSERT INTO entrance (tag,accont_id)VALUES(?,?)");
		        
		    	stmt.setString(1, tag);
		    	stmt.setString(2, outcome);
		
		
		        stmt.executeUpdate();
		        
		    } catch (SQLException ex) {
		        System.out.println(ex);
		    } finally {
		        Conexao.fechaConexao(con, stmt);
		    }
		
    }
    
    //Gravar entradas NÃO AUTORIZADAS em casa na BD
    public void insertDBNot(String tag , String outcome){
    	
    	PreparedStatement stmt = null;
    	
    	try {
            stmt = con.prepareStatement("INSERT INTO entrance (tag,accont_id)VALUES(?,?)");
            
        	stmt.setString(1, tag);
        	stmt.setString(2, "Conta não autorizada");


            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexao.fechaConexao(con, stmt);
        }
    	
    }
    
    //visualizar entradas
    
    
	public JSONObject readEntradas(String idHouse) {
	    	
	    	String value = null;
	    	    	
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        
	        JSONObject end = new JSONObject(); 
	        JSONArray user = new JSONArray();
	        Integer i = 0; 
	
	
	        try {
	        	
	            stmt = con.prepareStatement("SELECT a.id_card, u.username from account as a, users as u where a.id_card = ? and a.id_user = u.id_user");
		     
	        	stmt.setString(1, idHouse);
	        	rs = stmt.executeQuery();
	        	
	        	System.out.println(rs);
	        	
	        	while (rs.next()) {
	                
	        		user.add(1, rs.getString("username"));
	            }
	        	
	        	end.put("username" , user);	
	          
	            
	        } catch (SQLException ex) {
	        } finally {
	            Conexao.fechaConexao(con, stmt, rs);
	            return end;
	        }
			
	
	    }
    
}
