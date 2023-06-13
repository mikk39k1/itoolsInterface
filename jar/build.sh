#!/bin/bash

# Set the project directory on the server
PROJECT_DIR="/home/fomadmin/itoolsInterface/jar"

# Go to the project directory
cd "$PROJECT_DIR"

# Run the build command (example: using Maven)
mvn clean package

