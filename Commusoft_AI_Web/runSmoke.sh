#!/bin/bash

cd "$(dirname "$0")"

# Compile test classes
mvn test-compile

# Copy dependencies
mvn dependency:copy-dependencies

# Run the test
java -cp "target/classes:target/test-classes:target/dependency/*" org.testng.TestNG -testclass testcases.smokeOwner
