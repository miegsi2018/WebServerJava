package com.dai.test;
import com.dai.webServer.*;

import org.springframework.boot.SpringApplication;

import com.dai.Mqtt.*;
public class Main extends Listener{

	
	
	public static void main(String[] args) {
		new Listener().subscribe(topic);
		new WebServerApplication().startServer();
	}
}
