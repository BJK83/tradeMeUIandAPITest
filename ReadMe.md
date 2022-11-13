Download and install Java. My machine and Java config is:

		java -version

		java version "16.0.2" 2021-07-20

		Java(TM) SE Runtime Environment (build 16.0.2+7-67)

		Java HotSpot(TM) 64-Bit Server VM (build 16.0.2+7-67, mixed mode, sharing)

Download and install Maven. Maven config on my machine is as below:

		mvn -v
		Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)

		Maven home: C:\Users\XXXXXX\Downloads\apache-maven-3.8.6-bin\apache-maven-3.8.6

		Java version: 16.0.2, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-16.0.2

		Default locale: en_NZ, platform encoding: Cp1252

		OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"


Setup JAVA_Home and Maven Home environment variables. Refer to : 

		Java:     https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html

		Maven:    https://maven.apache.org/install.html

Download and install eclipse (or another IDE like IntelliJ). I have used eclipse to development of this framework and automation tests

Download the automation test repository from - https://github.com/BJK83/tradeMeUIandAPITest.git

Open this repo in eclipse, and navigate to the root directory, "/TradeMeUIandAPITest"

Right click on the POM.XML file, Click Maven, Click Update project

Tests can be run in one of the ways below:

		1.  Right click on the test runner file in directory "/TradeMeUIandAPITest/src/test/java/cucumberOptions/TestRunner.java", and run as JUnit .
		Test results for this will be shown in the IDE explorer

		2.  Right click on POM.xml, run as => Maven Test

		3.  In the IDE terminal, from the root folder - Use "mvn test", or "mvn verify".

Test result for options 2 and 3 are in the folder: \TradeMeUIandAPITest\target\cucumber-report
