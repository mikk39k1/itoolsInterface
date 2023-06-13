#!/bin/bash

# Grant read permissions to pom.xml file
chmod +r /home/fomadmin/itoolsInterface/pom.xml

# Change directory to project directory
cd /home/fomadmin/itoolsInterface

# Run Maven build
mvn clean install

# Move the generated JAR file to the jar directory a
mv /home/fomadmin/itoolsInterface/target/app.jar /home/fomadmin/itoolsInterface/jar/
