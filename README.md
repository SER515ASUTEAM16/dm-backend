# dm-backend [![Awesome](https://cdn.rawgit.com/sindresorhus/awesome/d7305f38d29fed78fa85652e3a63e154dd8e8829/media/badge.svg)](https://github.com/sindresorhus/awesome)

Backend service for Doodle Math

Load the project into IntelliJ



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
        "role" : "student"
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
-----------------


GET Request: 

    http://localhost:8080/auth/all

Sample Response(200):

    [
      {
        "id": 1,
        "name": "vineeth",
        "email": "vineethreddy.agusta@gmail.com",
        "password": "vineeth",
        "role": "student"
      },
      {
        "id": 3,
        "name": "amit",
        "email": "apande36@asu.edu",
        "password": "hack",
        "role": "student"
      }
    ]
    
    