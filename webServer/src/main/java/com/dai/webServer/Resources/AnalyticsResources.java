package com.dai.webServer.Resources;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dai.db.AnalyticsDB;


@RestController
public class AnalyticsResources {
	
	@PostMapping("/avgTemp")
	public String verifyTemp(@RequestBody String analytics) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(analytics);
		
		String dataIn = (String) jsonObject.get("dataI");
		
		String dataFi = (String) jsonObject.get("dataF");
		AnalyticsDB a = new AnalyticsDB();
		
		System.out.println(dataIn);
		System.out.println(dataFi);
		String fim = a.read( dataIn, dataFi);
		
		return fim;
	
	
	}

	
	@PostMapping("/avgHum")
	public String verifyHum(@RequestBody String analytics) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(analytics);
		
		String dataIn = (String) jsonObject.get("dataI");
		
		String dataFi = (String) jsonObject.get("dataF");
		AnalyticsDB a = new AnalyticsDB();
		
		System.out.println(dataIn);
		System.out.println(dataFi);
		String fim = a.readHumidade( dataIn, dataFi);
		
		return fim;
	
	
	}

}
