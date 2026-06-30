
# E-Commerce Test Automation Framework

This project is a Java-based Test Automation Framework developed for automating an E-Commerce web application.

The framework has been designed with scalability, maintainability, and readability in mind while following industry-standard automation practices.


## Author

- [@ChetanAG18](https://github.com/ChetanAG18)

- Email Address: agchetan18@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/ChetanAG18)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/chetan-ag/)




## 🚀 About Me
Hi, My Name is Chetan Geddappanavar and I have 5 years of experience in Automation Testing using technologies like Selenium Webdriver, Rest Assured, Postman, Jira, Jenkins and GitHub Actions. 

My major expertice is in Manual and Automation Testing and Java Programming Language.


## Prerequisites

Before executing the framework, ensure the following are installed.

- **Java 11** - Make Sure Java is installed and the JAVA_HOME environment is set.
- **Maven** - Ensure Maven is installed and added to the system path.
- Download Link: https://maven.apache.org/download.cgi


## Framework Features
-  Cross Browser Support

    The framework supports execution on multiple browsers.

    Example:
    Chrome,
    Firefox,
    Edge

    Browser selection is controlled using Maven command line parameters.

- Local and Cloud Execution

    Tests can be executed either:

    On the local machine
    On LambdaTest Cloud Grid

    No code changes are required. Only the execution parameter needs to be updated.

- Headless Execution

    For faster execution and CI/CD compatibility, the framework supports Headless mode.

    Headless mode can be enabled or disabled through Maven parameters.

- Data Driven Testing

    The framework supports multiple data sources.

    - CSV

        Implemented using:
        OpenCSV

        Suitable for lightweight datasets.

    - Excel

        Implemented using:
        Apache POI

        Useful for larger business datasets.

    - JSON

        Implemented using:
        Gson

        Useful for structured test data.

- Fake Test Data

    The framework uses the Java Faker library for generating dynamic test data such as:

    - Names
    - Email addresses
    - Phone numbers
    - Addresses
    - Random user information

    This helps eliminate dependency on static datasets.

- Reporting

    Execution reports are generated using Extent Reports.

    After execution completes, the report will be available at:
    reports.html

    The report contains:

    - Test Summary
    - Pass/Fail Status
    - Execution Time
    - Logs
    - Exception Details (if any)

- Logging

    Application and execution logs are generated using Log4j.

    Logs are stored inside:
    logs/

    These logs can be used for troubleshooting execution failures.

- Command Line Execution

    Tests can be executed directly from the terminal using Maven Surefire Plugin.

    Execution is completely parameterized.

    Supported parameters:

    | Parameter	| Description |
    |-----------|------------|
    | browser | Browser to execute tests |
    | isLambdaTest | Execute locally or on LambdaTest |
    | isHeadless | Execute browser in Headless mod |


## Technology Stack

| Component | Technology |
|-----------|------------|
| Programming Language | Java 11 |
| Build Tool | Maven |
| Test Framework | TestNG |
| Browser Automation | Selenium WebDriver |
| Cloud Execution | LambdaTest |
| Data-Driven Testing | OpenCSV, Apache POI, Gson |
| Fake Test Data | Java Faker |
| Reporting | Extent Reports |
| Logging | Log4j |
| Dependency Management | Maven |



## Installation

**Clone the Repository:**

```bash
  git clone https://github.com/ChetanAG18/ecommerce-test-automation-framework.git
  
  cd ecommerce-test-automation-framework
```

**Running Tests on LambdaTest:**

```bash
  mvn test -X -DsuiteXmlFile=testng.xml -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false
```

**Running Tests on Chrome browser on Local Machine in Headless Mode:**

```bash
  mvn test -X -DsuiteXmlFile=testng.xml -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true
```

## Reporting:
Reports: After the execution, a detailed HTML report will be generated at ./report.html.

The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests.

## Logs:
Logs are created during the test execution and stored in the ./logs/ directory.

## Integrated the project Github Actions
This automation framework is integrated with github actions.
The tests will be executed at 11:30pm IST every single day.

The report will be archieved in gh-pages branch
You can view the html reports at:
https://chetanag18.github.io/ecommerce-test-automation-framework/
