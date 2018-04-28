package com.dai.test;
import com.dai.webServer.*;
import com.dai.webServer.Mqtt.*;

import org.springframework.boot.SpringApplication;
public class Main extends Listener{

	
	
	public static void main(String[] args) {
		WebServerApplication webServer = new WebServerApplication();
		webServer.startServer();
		new Listener().subscribe(topic);
	}
}
