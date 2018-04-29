package com.dai.test;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dai.webServer.Objects.Readings;

public class CamelMain {

    public static void main(String[] args) {

        try {
            ApplicationContext springCtx = new ClassPathXmlApplicationContext("database-context.xml");

            CamelContext context = springCtx.getBean("employeeContext", CamelContext.class);

            context.start();

            ProducerTemplate producerTemplate = context.createProducerTemplate();

            // Insert Employee 1
            Readings emp1 = getReading1();
            String resp = producerTemplate.requestBody("direct:insert", emp1, String.class);

            // Insert Employee 2
            Readings emp2 = getReading2();
            resp = producerTemplate.requestBody("direct:insert", emp2, String.class);

            // Get Employee of inserted employees
            List<Readings> employees = producerTemplate.requestBody("direct:select", null, List.class);
            System.out.println("employees:" + employees);

        }
        catch (Exception e) {

            e.printStackTrace();

        }
    }

    private static Readings getReading1() {


        Readings emp = new Readings();

        emp.setAttr("empId1");
        return emp;

    }

    private static Readings getReading2() {

        Readings emp = new Readings();

        emp.setAttr("emp2");
        return emp;

    }
}

