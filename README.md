# Kre38Labs_Task
Kre38Labs_Task - Employee System
Steps to Run Project:
1. Download the repository from the Github - https://github.com/Honnur6268/Kre38Labs_Task.git
2. Open the Spring Boot project in your Eclipse IDE
3. Create Database in MySQL Workbench or Command Line Client
4. Change the Configuration from application.yml and and your configurations like your database username, password and database name in application.yml file to connect to Database.
5. Run the application as Spring boot app
6. Test the api using Postman or Swagger Ui

Rest Endpoints:

    a. GET - To view all Employees - [http://localhost:8080/api/task/tasks](http://localhost:8080/api/employee) 
    b. POST - To save Employees to db - http://localhost:8080/api/employee
            {
              "employeeName":"ABC",
              "address":"bangalore"
            }
            
    c. GET - To get the Employee by ID - http://localhost:8080/api/employee/{employeeId}
    d. DELETE - To delete the Employee by ID - http://localhost:8080/api/employee/{employeeId}

