#!/bin/bash

# Grant read permissions to pom.xml file
chmod +r /home/fomadmin/itoolsInterface/pom.xml

# Go to the project directory
cd /home/fomadmin/itoolsInterface

# Run the build command using the specified pom.xml file
mvn -f /home/fomadmin/itoolsInterface/pom.xml clean package

