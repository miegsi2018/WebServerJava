#!/bin/bash
sudo pkill java



cd ~/eclipse-workspace/WebServerJava/WebServerJava/webServer &&  mvn install -DskipTests && mvn exec:java    


