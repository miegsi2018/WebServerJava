package com.dai.webServer.Repos;

import java.util.Optional;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dai.webServer.Mqtt.Listener;
import com.dai.webServer.Objects.Readings;

@Repository
public interface ReadingsRepository extends JpaRepository<Readings, Long> {
	
	public Optional<Readings> findById(String id);

	public Readings save(JSONObject obj);

}
