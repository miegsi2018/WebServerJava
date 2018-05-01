package com.dai.webServer.Resources;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dai.db.AnalyticsDB;
import com.dai.webServer.Objects.Analytics;
import com.dai.webServer.Objects.User;



@RestController
public class AnalyticsResources {
	
	//IDK tho
	@PostMapping("/mediaTemp")

		public int verifyTemp(@RequestBody Analytics analytics) {
		
		Timestamp dataI = analytics.getDataI();
		Timestamp dataF = analytics.getDataF();
		
		AnalyticsDB a = new AnalyticsDB();
		
		a.read(analytics);
			
		
		return analytics.getTemperatura();
	
	
	}


}
