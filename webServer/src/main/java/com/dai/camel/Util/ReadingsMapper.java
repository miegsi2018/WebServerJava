package com.dai.camel.Util;

import com.dai.webServer.Objects.Readings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReadingsMapper {


    public Map<String, Object> getMap(Readings Reading) {
        Map<String, Object> answer = new HashMap<String, Object>();
        answer.put("Message", Reading.getAttr());
        return answer;
    }

    public List<Readings> readReadings(List<Map<String, String>> dataList) {

        System.out.println("data:" + dataList);

        List<Readings> readings = new ArrayList<Readings>();

        for (Map<String, String> data : dataList) {

            Readings reading = new Readings();

            reading.setAttr(data.get("Message"));

            readings.add(reading);
        }

        return readings;
    }
}	
	

