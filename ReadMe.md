Download and install Java. My machine and Java config is:

		java -version

		java version "16.0.2" 2021-07-20

		Java(TM) SE Runtime Environment (build 16.0.2+7-67)

		Java HotSpot(TM) 64-Bit Server VM (build 16.0.2+7-67, mixed mode, sharing)

Download and install Maven. Maven config on my machine is as below:

		Run command mvn -v from the terminal, it will show details as below.
		
		Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)

		Maven home: C:\Users\XXXXXX\Downloads\apache-maven-3.8.6-bin\apache-maven-3.8.6

		Java version: 16.0.2, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-16.0.2

		Default locale: en_NZ, platform encoding: Cp1252

		OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
		

Setup JAVA_Home and Maven Home environment variables. Refer to : 

		Java:     https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html

		Maven:    https://maven.apache.org/install.html

Download and install eclipse (or another IDE like IntelliJ, VS Code). I have used eclipse to develop this framework and automation tests. 
(Note: Eclipse seems to have have some issues cloning a repo from GIT, if so, use VS Code or any other to clone the git repo.)

	Download the automation test repository from - https://github.com/BJK83/tradeMeUIandAPITest.git
	
	use Branch - "main"

	Open this repo in eclipse, and navigate to the root directory, "/TradeMeUIandAPITest"

	Right click on the POM.XML file, Click Maven, Click Update project, or command - "mvn clean install"
	

Before running the tests:

	Install TestNG runner from eclipse market place - to run the tests as TestNG. Or you can use the Maven run config if you like. Details below.
	
	Note: I have used the latest Selenium - 4.6.0, which does not need the webdriver.exe installed as in the previous Selenium versions.
	
	Update your chrome browser to the latest stable version.


Running the Tests: Tests can be run in one of the ways below:

	IMPORTANT: BUILD THE MAVEN PROJECT = Right click on Project - Maven - Update Project

	1.  Right click on the test runner file in directory "/TradeMeUIandAPITest/src/test/java/cucumberOptions/TestRunner.java", and run as TestNG Test.		
	
	2.  Run the "/tradeMeUIandAPITest/src/test/java/suite.xml" as TestNg Suite
	
		Note:
		Test result report for options 1 and 2 is detailed, and can be accessed in the folder - tradeMeUIandAPITest\test-output. 
		If this does not show in the IDE project explorer, refresh the project or alternatively look for this folder on the file system under root directory.

	3.  Right click on POM.xml, run as => Maven Test

	4.  In the IDE terminal, from the root folder - Use "mvn test", or "mvn verify".

		Note: Test result for options 3 and 4 are in the folder: \TradeMeUIandAPITest\target\cucumber-report 

