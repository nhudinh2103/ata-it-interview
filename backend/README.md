

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

<p align="right">(<a href="#readme-top">back to top</a>)</p>


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

  


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Dinh Nguyen - [@My Linkedin](https://www.linkedin.com/in/dinh-nguyen-398529115/) - nhudinh2103@gmail.com

Project Link: [https://github.com/nhudinh2103/ata-it-interview/backend]([https://github.com/your_username/repo_name](https://github.com/nhudinh2103/ata-it-interview/backend))

<p align="right">(<a href="#readme-top">back to top</a>)</p>

