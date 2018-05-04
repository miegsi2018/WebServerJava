#!/bin/bash
sudo pkill mvn
cd ~/eclipse-workspace/WebServerJava/WebServerJava/webServer
st -e  mvn install && mvn exec:java &   

end
