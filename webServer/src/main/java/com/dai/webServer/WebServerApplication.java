package com.dai.webServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.dai.Mqtt.Listener;

@SpringBootApplication
public class WebServerApplication extends Listener {


	public void startServer() {
		
		SpringApplication.run(WebServerApplication.class );
		
		
	}

	public static void main(String[] args) {
		SpringApplication.run(WebServerApplication.class, args);
	}
}	