# Running co2emission Calculator



## **STEPS TO INSTALL Maven**

 1. The program uses maven as a build tool to maintain dependencies.
 2. Download Maven zip from  [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
 3. Install Maven if you have not installed by following the steps    (https://maven.apache.org/install.html)
 4. Once Maven is ready you can test maven with  maven -version from the command prompt.

## **STEPS TO RUN THE APPLICATION**

**If you prefer command line **
 1. Unpack the application from zip and extract.
 2. Navigate to the main directory where the sources are present,    where you see the POM.xml file
 3. Execute **mvn clean install** or **mvn clean install -DskipTests**(skip tests)  from the command line., This will install dependencies for you(make sure to connect to the internet)
 4. Execute **mvn test** if you want to run the unit tests separately 
 5. To execute the program use **mvn exec:java -Dexec.mainClass="com.sap.co2calculator.main.C02EmissionCalculator" -Dexec.args="--transportation-method train --distance 14.5  --output kg"**
 
**If you prefer eclipse Dev 2019-12 for Java**
  1. Open eclipse Dev 2019-12. 
  2. File -> Import->project as a maven project.
  3. Once imported right click -> select runAs and select maven clean.
  4. Select maven install to install dependencies
  5. Select maven test to run the unit tests or run Junit Test
  6. if you want to run the application right click runAs -> Run Configurations.
  7. Choose the correct  name C02EmissionCalculator on the left pane 
  8. On the right pane add the program arguments 

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTExNjExNDYyMDQsLTEyMjUxNDM5NDksMT
k2ODc3MjMyNSwtMTEwMDM2NzQ4M119
-->