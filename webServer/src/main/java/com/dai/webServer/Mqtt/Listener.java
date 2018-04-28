package com.dai.webServer.Mqtt;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dai.webServer.Objects.Readings;
import com.dai.webServer.Repos.ReadingsRepository;
import com.dai.webServer.Resources.ReadingsResouces;


import javax.sql.DataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;
/*******************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/


import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.json.simple.JSONObject;
/**
 * The Class Listner.
 * 
 * @author Yasith Lokuge
 */
public class Listener implements MqttCallback {
	
	@Autowired
	private ReadingsRepository leituraRepository;

	private ReadingsResouces o = new ReadingsResouces();
    /** The broker url. */
    private static final String brokerUrl = "tcp://alvesvitor.ddns.net:80";

    /** The client id. */
    private static final String clientId = "JavaSample";

    /** The topic. */
    public static final String topic = "#";
    
    private DataSource dataSource;
    
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
 

    /**
     * Subscribe.
     *
     * @param topic
     *            the topic
     */
    public void subscribe(String topic) {
	 

        try {

            MqttClient sampleClient = new MqttClient(brokerUrl, clientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
    	    connOpts.setUserName("dai");
    	    String password = "12345678";
    	    connOpts.setPassword(password.toCharArray());

            connOpts.setCleanSession(true);

            System.out.println("checking");

            System.out.println("Mqtt Connecting to broker: " + brokerUrl);
            sampleClient.connect(connOpts);
            System.out.println("Mqtt Connected");

            sampleClient.setCallback(this);
            sampleClient.subscribe(topic);

            System.out.println("Subscribed");
            System.out.println("Listening");

        } catch (MqttException me) {

            System.out.println("Mqtt reason " + me.getReasonCode());
            System.out.println("Mqtt msg " + me.getMessage());
            System.out.println("Mqtt loc " + me.getLocalizedMessage());
            System.out.println("Mqtt cause " + me.getCause());
            System.out.println("Mqtt excep " + me);
        }
    }

    
    
  
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.paho.client.mqttv3.MqttCallback#connectionLost(java.lang.
     * Throwable)
     */
    public void connectionLost(Throwable arg0) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.paho.client.mqttv3.MqttCallback#deliveryComplete(org.eclipse.
     * paho.client.mqttv3.IMqttDeliveryToken)
     */
    public void deliveryComplete(IMqttDeliveryToken arg0) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.paho.client.mqttv3.MqttCallback#messageArrived(java.lang.
     * String, org.eclipse.paho.client.mqttv3.MqttMessage)
     */
    public void messageArrived(String topic, MqttMessage message) throws Exception  {
    	
    	

        System.out.println("Mqtt topic : " + topic);
        System.out.println("Mqtt msg : " + message.toString());
        
        Object e = insert(message.toString());   
    }
    
    
    
   
 public Object insert(String message)  {
	 
	        System.out.println( "shit");
			JSONObject obj = new JSONObject();
            obj.put("attr", "{\n\t\"content-spec\":\"urn:spec://eclipse.org/unide/measurement-message#v2\",\n\t\"device\":\n\t{\n\t\t\"deviceID\":\"1883957\"\n\t},\n\t\"sensor\":\n\t{\n\t\"humidity\":\"52.00\",\n\t\"motion\":\"motion detected\",\n\t\"ldr\":\"390\",\n\t\"temperature\":\"29.00\"\n\t},\n\t\"alarm\":\n\t{\n\t\"state\":\"ON\"\n\t},\n\t\"color\":\n\t{\"r\":255,\"g\":0}\n}");
            Object a = ReadingsResouces.criarNaoEstatico(o, obj);
            return "shit";	
	 
 }
 
 
 

}