package com.dai.webServer.Resources;


import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.dai.db.AnalyticsDB;



@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@RequestMapping("/")

@RestController
public class AnalyticsResources {
	
	@PostMapping("/avgTemp")
	public String verifyTemp(@RequestBody String analytics) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(analytics);
		
		String dataIn = (String) jsonObject.get("dataI");
		String device = (String) jsonObject.get("device");		
		String dataFi = (String) jsonObject.get("dataF");
		AnalyticsDB a = new AnalyticsDB();
		System.out.println(dataIn);
		System.out.println(dataFi);
		
		System.out.println(dataFi);
		String fim = a.read(device,  dataIn, dataFi);

		
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
		
		System.out.println(dataIn);
		System.out.println(dataFi);
		
		JSONObject fim = a.returnGraph(device,  dataIn, dataFi);
		return fim;
	
	
	}


}
