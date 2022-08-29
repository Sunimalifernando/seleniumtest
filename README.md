# seleniumtest
## Automated ui tests for a social blogging site CRUD functionality

### Prerequisites: 
   ###### Java 8
   ###### Maven 3.0 or above

### Set up project in your IDE:
   > Open ‘seleniumtest’ level workspace project using InteliJ IDEA (community version) and enable auto enable dependency resolve feature.

### Execute Tests:
Execute via command-line;
1. Update the following properties of the test module pom file, with appropriate values
   > test.suite.file.name : The TESTNG xml file you want to execute (AFTReg.xml)
2. Go to test module directory (Example if you want to execute CDE test cases, go to cambio-taf-cosmic-cde-test) and execute:
   > mvn clean test
