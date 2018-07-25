#!/bin/bash
sudo pkill java


cd ~/webServerJava/webServer &&  mvn install -DskipTests && mvn exec:java    


