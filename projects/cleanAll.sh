#!/bin/sh

cd bytebuddy && mvn clean
cd ../fibonacci-aspectj && mvn clean
cd ../fibonacci-bytebuddy && mvn clean
cd ../fibonacci-spring-aop && mvn clean
cd ..
