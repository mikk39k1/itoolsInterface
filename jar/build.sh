#!/bin/bash

# Grant read permissions to pom.xml file
chmod +r /home/runner/work/itoolsInterface/itoolsInterface/pom.xml

# Change directory to project directory
cd /home/runner/work/itoolsInterface/itoolsInterface

# Run Maven build
mvn clean install

# Move the generated JAR file to the jar directory
mv /home/runner/work/itoolsInterface/itoolsInterface/target/app.jar /home/runner/work/itoolsInterface/itoolsInterface/jar/
