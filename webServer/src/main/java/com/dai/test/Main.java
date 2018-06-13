package com.dai.test;

import com.dai.webServer.*;
import com.dai.webServer.Mqtt.*;

public class Main extends Listener{
	
	public static void main(String[] args) {
	       
		//Listener listener = new Listener();
	        //listener.subscribe("data/fds");
			
		AlarmReceive alarm = new AlarmReceive();
	        alarm.subscribe("requestTHis");
	
		
		ReceiveRequests requests = new ReceiveRequests();
	        requests.subscribe("requestString");
		
		WebServerApplication webServer = new WebServerApplication();
		webServer.startServer();
		

		
		
	}

}
