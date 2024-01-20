# TestingNotIMDb
Testing functionalities of NotIMDb web app using Selenium and TestNG.

## **Description**

NotIMDb is a spin-off off IMDb, a very popular and well respected web application in cinema world. IMDb contains large database of movies, their IMDb rating, and various data about those movies.
NotIMDb provides intuitive interface for users. Through provided interface users can browse through movies from the database. Users can view details of a movie, movie ratings, reviews, etc.
Loged in users can leave a review for a movie. Also they can add a movie to their watchlist and they can later mark it as watched. That functionality provides a possibillity for a user to
track all watched movies.

TestingNotIMDb project is created to test the functionalities listed above this paragraph. This project contains 6 tests:

Login Test - testing login functionality

Logout Test - testing logout functionality

Register Test - testing new user registration functionality

Submit Review Test - testing submiting review for a movie by loged in user

Delete Movie Test - testing deleting a movie from the databse (only admin can perform this action)

Add to Watchlist Test - testing adding a movie to users watchlist

## **Getting Started**

### **Dependencies**

Following dependencies are required for this project to work properly:

selenium 4.16.1

testng 7.9.0

maven-surefire-report-plugin 3.2.3

maven-compiler-plugin 3.12.1

You can find these dependencies on this URL: https://mvnrepository.com/

### **Project requirements**

In order to properly run this project, it is necessary to clone NotIMDb repo first.

To run the frontend code it is necessary to install Node.js.

### **Executing program**

After cloning the NotIMDb repo, it is necessary to run backend code on localhost server and also frontend code on another localhost server.
To run NotIMDb backend on a local host port Visual Studio provides IIS Express button.
In terminal of IDE which contains frontend code it is necessary to run "npm start" command in order to run frontend code on a local host port.

Now NotIMDb is up and running and you can run the tests provided in this project. Navigate to _TestingNotIMDb/src/main/test/java_ to find all tests. To run a test, right click
on it and press the "Run" button.

### **Author**

Marko Kovačević