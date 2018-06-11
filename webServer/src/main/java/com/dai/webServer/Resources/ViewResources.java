package com.dai.webServer.Resources;

import java.net.URI;
import java.util.List;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dai.webServer.Objects.View;
import com.dai.webServer.Repos.ViewRepository;

import com.dai.db.AnalyticsDB;
@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@RequestMapping("/")
@RestController
public class ViewResources {
	
	@Autowired
	private ViewRepository ViewRepository;

	@GetMapping("/view2/{email}/{account}")
	public JSONObject getViews2 (@PathVariable String email, @PathVariable Long account) {
	

		AnalyticsDB a = new AnalyticsDB();

		AnalyticsDB b = new AnalyticsDB();
		
		JSONObject fim =  a.findDivision(email);	
		JSONObject houses = b.findHouse(account);
		fim.put("array2", houses);



		return fim;
		
	};


	@GetMapping("/view/{email}")
	public List<View> getViews(@PathVariable String email) {
		



		return ViewRepository.findThem(email);

	};

	
};
