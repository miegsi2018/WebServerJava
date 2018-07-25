package com.dai.webServer.Resources;


import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.dai.db.AnalyticsDB;
import org.springframework.web.bind.annotation.RequestMapping;



@CrossOrigin(origins = "http://localhost:3400", maxAge = 3600)
@RequestMapping("/")

@RestController
public class AnalyticsResources {
	
	@PostMapping("/avgTemp")
	public JSONObject verifyTemp(@RequestBody String analytics) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(analytics);
		
		String dataIn = (String) jsonObject.get("dataI");
		String device = (String) jsonObject.get("device");		
		String dataFi = (String) jsonObject.get("dataF");
		AnalyticsDB a = new AnalyticsDB();
		System.out.println("temp");
		
		System.out.println(dataFi);
		JSONObject fim = a.read(device,  dataIn, dataFi);

		
		return fim;
	
	
	}
	
	@PostMapping("/avgHouse")
	public JSONObject verifyHouse(@RequestBody String analytics) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(analytics);
		
		String dataIn = (String) jsonObject.get("dataI");
		String email = (String) jsonObject.get("email");		
		String dataFi = (String) jsonObject.get("dataF");
		AnalyticsDB a = new AnalyticsDB();
		
		System.out.println(dataFi);
		JSONObject fim = a.readHouse(email,  dataIn, dataFi);

		
		return fim;
	
	
	}


	
	@PostMapping("/avgHum")
	public String verifyHum(@RequestBody String analytics) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(analytics);
		
		String dataIn = (String) jsonObject.get("dataI");
		
		String device = (String) jsonObject.get("device");		
		String dataFi = (String) jsonObject.get("dataF");
		AnalyticsDB a = new AnalyticsDB();
		
		System.out.println(dataIn);
		System.out.println(dataFi);
		String fim = a.readHumidade(device, dataIn, dataFi);
		

		return fim;
	
	
	}
	
	
	@PostMapping("/returnGraph")
	public JSONObject returnGraph(@RequestBody String analytics) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(analytics);
		
		String dataIn = (String) jsonObject.get("dataI");
		
		String device = (String) jsonObject.get("device");		
		String dataFi = (String) jsonObject.get("dataF");
		AnalyticsDB a = new AnalyticsDB();
		
		AnalyticsDB b = new AnalyticsDB();
		System.out.println(dataIn);
		System.out.println(dataFi);
		
		JSONObject tempHum = a.read(device,  dataIn, dataFi);
		JSONObject fim = b.returnGraph(device,  dataIn, dataFi);

		fim.put("tempHum", tempHum);	
		return fim;
	
	
	}
	
	// Rota para visualizar entradas em casa
	
	@PostMapping("/Entradas")
	public JSONObject verifyEntrada(@RequestBody String analytics) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(analytics);
	        JSONObject finalArray = new JSONObject(); 
	
		
		String idEntrada = String.valueOf(jsonObject.get("id_house"));
		
		AnalyticsDB a = new AnalyticsDB();
		
		JSONObject fim = a.readEntradas(idEntrada);
		finalArray.put("data", fim);
		
		return fim;
	
	}
	

	@GetMapping("/sensor")
	public JSONObject readSensor() throws ParseException {
		
		AnalyticsDB a = new AnalyticsDB();
		
		JSONObject fim = a.readSensor();
		
		return fim;
	
	}
	

}
