

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

The requirement is to create a web application with ReactJS for user to search and view orders as shown below.

- The user can search the orders by selecting starting date and ending date.

-  The period and status values are fixed with a single value of ‘Transmission’ and ‘Waiting’ for the first MVP. You can design the data model that should be
returned from the backend service and create the mocked data at frontend for the test.

- The UI should support
responsive which will display only the 4 columns of Account, Operation, Symbol and Status for mobile screen.

<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

- Install node and npm (Follow this link if you use ubuntu)

https://www.hostinger.com/tutorials/how-to-install-node-ubuntu

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/84d5a1c9-1cef-4a7f-88f2-51247839197a)

- Install vscode (I use it as an IDE for coding ReactJS)

- Clone source code from this repo (frontend folder).

### Installation
- For building project, we use npm as a package management.

   ```
   cd ./frontend
   npm install
   ```

  This image show the build had run successfully
  
  ![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/1a3eb41a-e944-4de8-80a1-89ef4b857516)


- After build succeed, we can run frontend code with command:
  
   ```
   npm run dev
   ```
   
  This will run our web front end at port 5173 (if this port was not already in use).

  ![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/9df1dcda-5dcc-4d90-a2c5-50fd86965022)

- In case you want to run the test, please run the command:

  ```
  npm test
  ```

  ![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/15736342-1c9d-4dab-85fe-165b889a302d)


## Project structure

- src: Typescript code for this frontend ReactJS app.

- src/css: Where your style css file.

- src/test: Test code for this frontend app.

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/c3bb1cf4-1e0f-4c1a-9a7d-d85c0a84d3ad)



<!-- USAGE EXAMPLES -->
## Usage

After running frontend application successfully, you can see the web ui like this

- Browser

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/e9a5dffd-e7dd-4dae-b414-f2591f26c9f9)

- Mobile:

![image](https://github.com/nhudinh2103/ata-it-interview/assets/17499217/9eee19dd-b3d2-4c2f-b628-8de06c62cf90)


rootUrl: http://localhost:5173

### Note:
- Currently, my implementation only support filter based on start date, end date as well as filter by accountNo.


<!-- CONTACT -->
## Contact

Dinh Nguyen - [@My Linkedin](https://www.linkedin.com/in/dinh-nguyen-398529115/) - nhudinh2103@gmail.com

Project Link: [https://github.com/nhudinh2103/ata-it-interview/frontend]([https://github.com/your_username/repo_name](https://github.com/nhudinh2103/ata-it-interview/frontend))

