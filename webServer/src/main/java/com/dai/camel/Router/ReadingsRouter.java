package com.dai.camel.Router;

import com.dai.webServer.Objects.Readings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import com.dai.camel.Util.*;

public class ReadingsRouter  extends RouteBuilder {

	
	

    @Override
    public void configure() throws Exception {

        from("direct:insert").log("Inserted new Reading").bean("ReadingsMapper", "getMap")
            .to("sqlComponent:{{sql.insertReadings}}");

        from("direct:select").to("sqlComponent:{{sql.getAllReadings}}")
            .bean("Readings", "readReadings").log("");
    }

}	
	

