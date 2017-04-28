#!/bin/bash

export HADOOP_CLASSPATH=/root/workspace/mrsample/target/classes

#print configuration
#hadoop com.dengdd.mrsample.ConfigurationPrinter -conf ./src/main/resources/hadoop-cluster.xml

hadoop com.dengdd.mrsample.MaxTemperatureDriver -conf ./src/main/resources/hadoop-local.xml ./src/main/resources/data/sample.txt output



