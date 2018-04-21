package com.dai.webServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dai.webServer.mqtt.Listener;

@SpringBootApplication
public class WebServerApplication extends Listener {

	public static void main(String[] args) {
		SpringApplication.run(WebServerApplication.class, args);
		new Listener().subscribe(topic);
	}
}
