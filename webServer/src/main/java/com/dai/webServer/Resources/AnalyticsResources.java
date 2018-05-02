package com.dai.webServer.Resources;

import java.sql.Timestamp;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dai.db.AnalyticsDB;
import com.dai.webServer.Objects.Analytics;
import com.dai.webServer.Objects.User;



@RestController
public class AnalyticsResources {
	
	@PostMapping("/mediaTemp")
	public String verifyTemp(@RequestBody String analytics) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(analytics);
		
		Object dataI = jsonObject.get("dataI");
		Object dataF = jsonObject.get("dataF");
		
		String dataIn = (String) jsonObject.get("dataI");
		
		String dataFi = (String) jsonObject.get("dataF");
		AnalyticsDB a = new AnalyticsDB();
		
		System.out.println(dataIn);
		System.out.println(dataFi);
		
		String fim = a.read(dataIn, dataFi);
		
		return fim;
	
	
	}


}
