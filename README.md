# Report Generator ( NatWest Group Assignment )

## Description
This is a Spring Boot application that ingests CSV files and generates reports based on configurable transformation rules. The report generation can be scheduled and triggered via a REST API. The application is designed to handle large files (up to 1GB) and transform data efficiently.

## Features
- Ingest CSV files
- Generate reports based on configurable transformation rules
- Schedule report generation
- Trigger report generation via REST API
- Supports future enhancements for different file formats (Excel, JSON, etc.)
- Configurable transformation rules
- Handles large files efficiently

## Technologies Used
- Spring Boot
- Spring Batch
- OpenCSV
- Lombok
- H2 Database
- Maven

## Getting Started

### Prerequisites
- Java 17
- Maven

### Installation
1. Clone the repository :
   ```bash
   git clone <https://github.com/ArpitAggarwal10/NatWest_Group_Assignment.git>
2. Navigate to the project directory :
    ```bash
   cd reportgenerator
3. Build the project :
    ```bash
   mvn clean install
4. Run the application :
    ```bash
   mvn spring-boot:run

## Usage

### REST API

- #### Generate Report
    ```http
    GET /generateReport?inputFilePath=path/to/input.csv&referenceFilePath=path/to/reference.csv&outputFilePath=path/to/output.csv
    ```

- #### Example
  Request :
    ```
    GET /generateReport?inputFilePath=/data/input.csv&referenceFilePath=/data/reference.csv&outputFilePath=/data/output.csv
    ```
  Response :
    ```
    Report generated successfully.
    ```

### Logging
- Appropriate logging is set up using the `SLF4J` logging framework. Check the `application.properties` for logging configurations.

### Testing
- Unit test cases are included in the `src/test` directory. Run the tests using :
    ```bash
    mvn test
    ```
  
## Directory Structure
```sh
reportgenerator
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── reportgenerator
│   │   │               ├── config
│   │   │               │   └── SchedulingConfig.java
│   │   │               ├── controller
│   │   │               │   └── ReportController.java
│   │   │               ├── model
│   │   │               │   ├── Input.java
│   │   │               │   ├── Reference.java
│   │   │               │   └── Output.java
│   │   │               ├── repository
│   │   │               │   └── CsvRepository.java
│   │   │               └── service
│   │   │                   └── ReportService.java
│   │   ├── resources
│   │   │   ├── application.properties
│   │   │   └── data
│   │   │       ├── input.csv
│   │   │       └── reference.csv
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── reportgenerator
│                       ├── controller
│                       │   └── ReportControllerTest.java
│                       ├── service
│                       │   └── ReportServiceTest.java
│                       └── repository
│                           └── CsvRepositoryTest.java
└── pom.xml
```

## Contributing
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## Contact
- For any questions or suggestions, please contact `arpitaggarwal1012@gmail.com`.
```vbnet
This README file provides a comprehensive overview of the project, its installation, usage, directory structure, and contribution guidelines. It is structured to help anyone using or contributing to the project understand its purpose and how to set it up and run it.
```


  



