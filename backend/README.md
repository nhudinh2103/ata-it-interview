

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
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
- Install JDK 17
  
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

## Project structure

- src/main/java: Java source code for backend.

- src/main/resources: Configs file (like application.properties) and file contains dummy data.
  
- src/test/java: Test code (For simplicity, I just write two simple test cases).

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/843a84ad-4c6a-49bc-af13-287ce05b106d)


<!-- USAGE EXAMPLES -->
## Usage

After running backend application successfully, you can call Rest API from PostMan.

rootUrl: http://localhost:8081

1. Get jobs which salary greater or equal than X value

   http://localhost:8081/job_data?search=salary>=1000000000000

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/12731dd7-df44-4ef6-b185-bea97a18356f)


2. Get jobs which salary greater or equal than X value with gender is Female.

   http://localhost:8081/job_data?search=salary>=9999999999|gender:Female

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/8e649581-e945-4c0a-977d-305522826fd8)

3. Only retrieve 4 fields: gender, salary, employer, timestamp with search conditions

   http://localhost:8081/job_data?search=salary>=1000000000000&fields=gender,salary,timestamp,timestampStr,employer

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/d0b5c0fb-9519-458f-ae3b-3f107aed2e50)

4. Sort by salary desc

   http://localhost:8081/job_data?search=salary>=1000000000000&fields=gender,salary,timestamp,timestampStr,employer&sort=salary,desc

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/db3cb6a7-ebb4-49d8-8c16-a1df84807142)

5. Sort by multiple criteria: sort gender asc, than sort salary desc

   http://localhost:8081/job_data?search=salary:1000000&fields=gender,salary,timestamp,timestampStr,employer&sort=gender,asc@@timestamp,desc
   
![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/df2e32ce-da4d-4e5e-aa39-5fe2b3275ca0)

6. Sort by yearsOfExperience asc

   http://localhost:8081/job_data?search=salary>=9999999999|gender:Male&sort=yearsOfExperience,asc

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/c2a17559-6e4d-4195-9b67-842b9cbf3e20)

7. Sort by yearsAtEmployer asc

   http://localhost:8081/job_data?search=salary>=9999999999|gender:Male&sort=yearsAtEmployer,asc

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/409cedb4-75bd-4fe3-b4d6-77b4b58c00d9)

### Note:
- This's not implemented authentication / security yet (Should use jwt for authentication).

- Currently my implementation only handle issues when sort with string at these fields: salary, yearAtEmployer, yearsOfExperience.

- In search query, I use | as separator for multiple search conditions

  Example: **/job_data?search=\<criteria1\>|\<criteria2\>|...\<criteriaN\>)**
  
- In sort query, I use @@ for multiple sort entry with each entry separate by comma

  Example: **/job_data?sort=\<criteria1\>,\<asc/desc\>@@\<criteria2\>,\<asc/desc\>@@...\<criteriaN\>,\<asc/desc\>**

- For detail search criteria operation, please look at enum in com.ata.interview.backend.util.SearchOperation:

  ![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/c6f55019-6846-4d62-a717-0e4f41436458)

- This backend app use h2 db as an memory database (for store dummy data). In case you want to access, please use user and password in application.properties file.

  http://localhost:8081/h2-console

  ![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/bbd4f431-1173-429c-867c-9503ad4131a2)



<!-- CONTACT -->
## Contact

Dinh Nguyen - [@My Linkedin](https://www.linkedin.com/in/dinh-nguyen-398529115/) - nhudinh2103@gmail.com

Project Link: [https://github.com/nhudinh2103/ata-it-interview/backend]([https://github.com/your_username/repo_name](https://github.com/nhudinh2103/ata-it-interview/backend))

