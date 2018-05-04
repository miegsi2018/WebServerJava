#!/bin/bash

pkill mvn

st -e mvn install && mvn exec:java &   

