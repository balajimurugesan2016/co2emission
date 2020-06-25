# Running co2emission Calculator



## **STEPS TO INSTALL Maven**

 1. The program uses maven as a build tool to maintain dependencies.
 2. Download Maven zip from  [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
 3. Install Maven if you have not installed by following the steps    (https://maven.apache.org/install.html)
 4. Once Maven is ready you can test maven with  maven -version from the command prompt.

## **STEPS TO RUN THE APPLICATION**

 1. Unpack the application from zip and extract.
 2. Navigate to the main directory where the sources are present,    where you see the POM.xml file
 3. Execute **mvn clean install** or **mvn clean install -DskipTests**(skip tests)  from the command line., This will install dependencies for you(make sure to connect to the internet)
 4. Execute **mvn test** if you want to run the unit test separately 
 5. To execute the program use **mvn exec:java -Dexec.mainClass="com.sap.co2calculator.main.C02EmissionCalculator" -Dexec.args="--transportation-method train --distance 14.5  --output kg"**
 

<!--stackedit_data:
eyJoaXN0b3J5IjpbMTQ4ODMyMTQ0NywtNzY5NDg1MzE2XX0=
-->