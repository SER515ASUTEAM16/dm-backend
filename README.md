# dm-backend [![Awesome](https://cdn.rawgit.com/sindresorhus/awesome/d7305f38d29fed78fa85652e3a63e154dd8e8829/media/badge.svg)](https://github.com/sindresorhus/awesome)

Backend service for Doodle Math

Load the project into IntelliJ

Requirements: <b>`Java 8, does not work on 10 and 11`</b>



Open Terminal:
-------------------
<b>Build:</b> ./gradlew clean build

<b>Run:</b> ./gradlew bootRun

Health check:
------------
After the server starts on port 8080, Visit the following link to check health: http://localhost:8080/health

User Registration:
-----------------

POST Request: 

    http://localhost:8080/auth/register

Sample Request:
    
    {
        "name" : "vineeth",
        "email" : "vineethreddy.agusta@gmail.com",
        "password" : "vineeth",
        "role" : "student",
        "grade" : "1-5"
    }

Sample Response(200):

    SUCCESS

Login By Email:
--------------


POST Request: 

    http://localhost:8080/auth/loginByEmail

Sample Request:
    
    {
    	"email" : "apande36@asu.edu",
    	"password" : "hack1"
    }

Sample Response(200):

    SUCCESS


Login By Username:
-----------------


POST Request: 

    http://localhost:8080/auth/loginByName

Sample Request:
    
    {
    	"name" : "amit",
    	"password" : "hack2"
    }

Sample Response(200):

    SUCCESS
    
    
Get All Users:
--------------


GET Request: 

    http://localhost:8080/auth/all

Sample Response(200):

    [
      {
        "id": 1,
        "name": "vineeth",
        "email": "vineethreddy.agusta@gmail.com",
        "password": "vineeth",
        "role": "student",
        "grade": "1-5"
      },
      {
        "id": 3,
        "name": "amit",
        "email": "apande36@asu.edu",
        "password": "hack",
        "role": "student",
        "grade": "1-5"
      }
    ]
    

Get All Students in a grade:
----------------------------

GET Request url: http://localhost:8080/teacher/getAllStudentsInGrade/1-5


Sample Response(200):

    [
      {
        "id": 7,
        "name": "ccmcbc",
        "email": "CCFindler@gmail.com",
        "password": "google",
        "role": "student",
        "grade": "1-5"
      }
    ]
    
    
Create Assignment By a Teacher:
----------------------------

POST Request URL: http://localhost:8080/teacher/createAssignment

Sample Request:

    {
        "name": "Give a name for the assignment",
        "description": "Give a description of the assignment",
        "content": "Content of the assignment and equations",
        "author": "Findler",
        "creationDateTime": "12/28/2019"
    }

Sample Response:

    SUCCESS

Get all assignments by a teacher:
----------------------------

GET Request URL: `http://localhost:8080/teacher/getAssignments/{teacher_name}`

Based on the above request under the tag `Create Assignment By a Teacher:`, the sameple request is `http://localhost:8080/teacher/getAssignments/Findler`

Sample Response:
    
    [
      {
        "id": 10,
        "name": "Give a name for the assignment",
        "description": "Give a description of the assignment",
        "content": "Content of the assignment and equations",
        "author": "Findler",
        "creationDateTime": "12/28/2019"
      }
    ]

Register students under a teacher:
----------------------------

POST Request:

    [
      {
        "id": 7,
        "name": "ccmcbc",
        "email": "CCFindler@gmail.com",
        "grade": "1-5"
      },
      {
        "id": 8,
        "name": "akatsuki",
        "email": "Findler@gmail.com",
        "grade": "1-5"
      }
    ]
    
Sample Response:

    SUCCESS
    

Get all students registered under a teacher:
-----------------------------------

GET Request URL: `http://localhost:8080/teacher/sharingan/registeredStudents`

Sample Response:

    [
      {
        "id": 11,
        "name": "ccmcbc",
        "email": "CCFindler@gmail.com",
        "teacher": "sharingan"
      },
      {
        "id": 12,
        "name": "akatsuki",
        "email": "Findler@gmail.com",
        "teacher": "sharingan"
      }
    ]
