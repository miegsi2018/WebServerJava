package com.dai.webServer.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dai.webServer.Objects.Analytics;
import com.dai.webServer.Objects.User;



@RestController
public class AnalyticsResources {
	
	@GetMapping("/media")

	public String getTemp(@RequestBody Analytics analytics) {
		
		String temp = analytics.getTemperatura();
	
		return temp;
	
	
	}

}
