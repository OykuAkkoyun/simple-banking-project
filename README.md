# Simple Banking Project with Spring Boot

Prerequisites & Project Tech Stack
-----------------------------------
Java 11, 
Spring Boot 2.7.2, 
Spring Cloud 2021.0.3, 
Netflix Eureka Service Client, 
H2 Database (in-memory persistence data storage)
</br>
</br>

Service Registry
-----------------
The service registry is simply an application that keep the track of services inside the microservice architecture, and It should be highly available and up to date.
In this project Netflix Eureka is used for service registry.

</br>

Application Structure 
----------------------
In this project, there are 3 different APIs : Customer, Account, Transaction. Database per service pattern has applied.
Every service will be register to Eureka Server while starting. Each service communicate with each other using FeignClient with the help of service registry load balancer though each API doesn't need to know other API's endpoint addresses.

</br>

1- Customer Service API 
-------------------------
This API only serves customer's information. It is assumed that customers already exist.
Every time the application is starting, the first step is running the data.sql file. It helps to insert sample customer data into customer in-memory database. 

Sample Data:

<img width="414" alt="Screen Shot 2022-08-11 at 22 03 14" src="https://user-images.githubusercontent.com/74348379/184219134-c3d194e3-d6f1-447c-b31d-18d2064cb5cf.png">

</br>

* getCustomers

This endpoint returns all customers records.
Endpoint: http://localhost:8083/api/customer

</br>

* getCustomer

This endpoint accepts customerId to get related customer information.
Endpoint: http://localhost:8083/api/customer/{customerNumber}

</br>

2- Account Service API
-------------------------
This API has 4 different methods to serve account related requests.

</br>

* openAccount 

This endpoint accepts the user information (customerID, initialCredit) to open a new account for customer.
If initialCredit is not 0, a transaction will be sent to the new account.
Endpoint: http://localhost:8085/api/account (POST)

</br>

* getAccount

This endpoint takes accountNumber to get account info. 
Endpoint: http://localhost:8085/api/account/{accountNumber}

</br>

* getAccounts

This endpoint returns all records of account.
Endpoint: http://localhost:8085/api/account (GET)

</br>

* getAccountDetails

This endpoint takes accountNumber to get account information and with account related customer and transaction details.
Endpoint: http://localhost:8085/api/account/detail/{accountNumber}

</br>

3- Transaction Service API
-----------------------------
This API called by Account API to create transaction records.

</br>

* deposit

This endpoint allows to user to deposit amount to their account. It can be used both opening a new account and making a deposit already opened account.
Endpoint: http://localhost:8084/api/transaction/deposit (POST)

</br>

Project Architecture 
---------------------

<img width="641" alt="Screen Shot 2022-08-11 at 22 34 08" src="https://user-images.githubusercontent.com/74348379/184224278-afc39c1f-c7be-439e-ba02-666b4910bb73.png">

</br>

* Postman

Postman collection is included into Github project page.
