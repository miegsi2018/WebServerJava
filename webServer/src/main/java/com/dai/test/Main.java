package com.dai.test;
import com.dai.webServer.*;
import com.dai.webServer.Mqtt.*;

import org.springframework.boot.SpringApplication;
public class Main extends Listener{

	
	
	public static void main(String[] args) {
		new Listener().subscribe(topic);
		new WebServerApplication().startServer();
	}
}
