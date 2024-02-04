

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Backend Exercise : Expose an API for querying job data

The goal of this exercise is to design a read-only API (REST) that returns one or more records from static set of job data.

User Story: As a developer I want to

list job data via API GET request

- Filter by one or more fields/attributes (e.g. /job_data?salary[gte]=120000) (Show only filtered row. Expected filter able column: job title, salary, gender )
  
- Filter by a sparse fields/attributes (e.g. /job_data?fields=job_title,gender,salary) (Show only filtered column)
  
- Sort by one or more fields/attributes (e.g. /job_data?sort=job_title&sort_type=DESC)

A few quick notes on submitting the Backend Exercise

- Don't worry about any web application concerns other than serializing JSON and returning via a GET request.
- Feel free to design the URL structure and JSON schema that you believe creates the best client/consumer experience. We want to see how you initiate a new project, project structure and design.


<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites
- Install JDK 17 (depends on your OS)
  Follow this link if you use ubuntu: https://www.rosehosting.com/blog/how-to-install-java-17-lts-on-ubuntu-20-04/
  
- Install eclipse (Currently I use spring tool suite 4)
  https://spring.io/tools

- Clone source code from this repo (backend folder).

### Installation
- For building project, we use gradle as a package management and build tools.

   ```
   cd ./backend
   ./gradlew build
   ```

  This image show building gradle successfully
  
  ![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/8e2c627d-cb23-4e9d-b952-732f2794ed6f)

- After build succeed, we will have jar file name **backend-1.0.0.jar** in **./backend/build/libs directory**.
  To run application, just run the jar file with command:

   ```
   cd ./backend/build/libs
   java -jar ./backend-1.0.0.jar
   ```
   
  This will run our spring boot backend at port 8081.

  ![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/179a18b9-0d6a-4667-ae91-699d48d6d4e9)


  **Note**: in case you got error Port 8081 was already in use (due to another application had already started in port 8081)

  ![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/ae622226-b185-4ca3-8e79-3e95056add30)

  You can change default port in application in **src/main/resources/application.properties** to another port and rebuild application.
  ![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/871f62e6-798b-4d69-80dd-1ff00a471051)

  



<!-- USAGE EXAMPLES -->
## Usage

After running backend application successfully, you can call Rest API from PostMan.

rootUrl: http://localhost:8081

1. Get jobs which salary greater or equal than X value

   http://localhost:8081/job_data?search=salary>=1000000000000

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/e6f32e1f-a738-41a2-b7e6-239078fccf51)

2. Get jobs which salary greater or equal than X value with gender is Female.

   http://localhost:8081/job_data?search=salary>=9999999999|gender:Female

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/9d8a9e1a-0da2-4ed4-89bc-d45772a9cbc4)

3. Only retrieve 4 fields: gender, salary, employer, timestamp with search conditions

   http://localhost:8081/job_data?search=salary>=1000000000000&fields=gender,salary,timestamp,employer

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/d0af53c0-cf35-40ad-a939-ef2e8f1f1489)

4. Sort by salary desc

   http://localhost:8081/job_data?search=salary>=1000000000000&fields=gender,salary,timestamp,employer&sort=salary,desc

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/1105d8e0-e79a-4d0f-a84c-d95b02205c6e)

5. Sort by multiple criteria: sort gender asc, than sort salary desc

   http://localhost:8081/job_data?search=salary:1000000&fields=gender,salary,timestamp,employer&sort=gender,asc@@timestamp,desc
   
![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/2dbc26da-fcc0-47e9-a390-f9169f10b6bd)

### Note:
- In search query, I use | as separator for multiple search conditions

  Example: **/job_data?search=<criteria1>|<criteria2>|...<criteriaN>)**
  
- In sort query, I use @@ for multiple sort entry with each entry separate by comma

  Example: **/job_data?sort=<criteria1>,<asc/desc>@@<criteria2>,<asc/desc>@@...<criteriaN>,<asc/desc>**

- For detail search criteria operation, please look in enum com.ata.interview.backend.util.SearchOperation:

  ![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/c6f55019-6846-4d62-a717-0e4f41436458)


<!-- CONTACT -->
## Contact

Dinh Nguyen - [@My Linkedin](https://www.linkedin.com/in/dinh-nguyen-398529115/) - nhudinh2103@gmail.com

Project Link: [https://github.com/nhudinh2103/ata-it-interview/backend]([https://github.com/your_username/repo_name](https://github.com/nhudinh2103/ata-it-interview/backend))

