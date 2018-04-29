package com.dai.webServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dai.webServer.Mqtt.Listener;


@SpringBootApplication
public class WebServerApplication {


	public void startServer() {
		
		SpringApplication.run(WebServerApplication.class );
		
		
	}

}	