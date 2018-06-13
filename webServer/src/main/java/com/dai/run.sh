#!/bin/bash
sudo pkill java


cd ~/WebServerJava/webServer &&  mvn install -DskipTests && mvn exec:java    


