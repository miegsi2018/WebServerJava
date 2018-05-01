package com.dai.test;

import com.dai.webServer.*;
import com.dai.webServer.Mqtt.*;
import com.dai.webServer.Objects.Analytics;

public class Main extends Listener{

	
	
	public static void main(String[] args) {
	//	Listener listener= new Listener();
	//	listener.subscribe(topic);
		WebServerApplication webServer = new WebServerApplication();
		webServer.startServer();
		

		
		
	}

}
