# Routes

Routes REST Service uses Spring Boot +Hibernate + PostgreSQL.This REST Service helps the user to get Bus Route Number 
with given source and destination.

Spring Boot
-------------

Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can “just run”. 
We take an opinionated view of the Spring platform and third-party libraries so you can get started easily.
Most Spring Boot applications need very little Spring configuration.

Hibernate Framework
--------------------

Hibernate framework simplifies the development of java application to interact with the database. 
Hibernate is an open source, lightweight, ORM (Object Relational Mapping) tool.
An ORM tool simplifies the data creation, data manipulation and data access. 
It is a programming technique that maps the object to the data stored in the database.

PostgreSQL
-----------
PostgreSQL is the Database used for this REST API.PostgreSQL is a powerful, open source object-relational database system. 
Its features which makes it a very strong are Reliability,Correctness,Data Integrity.

Download PostgreSQL here : https://www.postgresql.org/download/

REST Endpoints
----------------

Get Bus Routes:

Endpoint:http://localhost:8080/rest/bus/routenumber?source=Broadway&destination=Kundrathur

Result:

	[{"source":"broadway","destination":"kundrathur","route_Num":"60A"},
	{"source":"broadway","destination":"kundrathur","route_Num":"88K"},
	{"source":"broadway","destination":"kundrathur","route_Num":"X188E"}]

Get Route By ID:

Endpoint:http://localhost:8080/rest/bus/route/20

Result:

	{"route_id":20,"source":"red hills","destination":"cmbt"}


Get All Routes:

Endpoint: http://localhost:8080/rest/bus/routes 

Result:

	[{"route_id":1,"source":"broadway","destination":"taramani"},
	{"route_id":2,"source":"taramani","destination":"broadway"},
	{"route_id":3,"source":"ambathur estate","destination":"broadway"},
	{"route_id":4,"source":"broadway","destination":"ambathur estate"},
	{"route_id":5,"source":"vallalar nagar","destination":"periyar nagar"}]
	

Get Cities which contains Images:

Endpoint: http://localhost:8080/BusRoutes/images/city

Result:

	[Adyar, Anna Nagar, Chennai Central, Chepauk, Chromepet, Egmore, Guindy, Koyambedu, Mamallapuram, Meenambakkam, Mylapore, Nungambakkam, Poonamalee, Royapettah, Taramani, Tnagar, Triplicane, Vadapalani, Vandalur, Velachery]
	
Get Images by City:

Endpoint: http://localhost:8080/BusRoutes/images/city/Adyar

	[{"url":"http://localhost:8080/BusRoutes//images/city/Adyar/4380_IIT_Madras.jpg"},
	{"url":"http://localhost:8080/BusRoutes//images/city/Adyar/cancer institute.jpg"},
	{"url":"http://localhost:8080/BusRoutes//images/city/Adyar/CLRI Building_0.JPG"},
	{"url":"http://localhost:8080/BusRoutes//images/city/Adyar/cooum river.jpg"},
	{"url":"http://localhost:8080/BusRoutes//images/city/Adyar/cooum_0_0.jpg"},
	{"url":"http://localhost:8080/BusRoutes//images/city/Adyar/fortis-malar-hospit_905330f.jpg"},
	{"url":"http://localhost:8080/BusRoutes//images/city/Adyar/iit-madras_650x400_41456254328.jpg"},
	{"url":"http://localhost:8080/BusRoutes//images/city/Adyar/malar hospital.jpg"}]
	
Get Image: 

Endpoint: http://localhost:8080/BusRoutes/images/city/Chromepet/Amenitites%20and%20urban.jpg

	
![Alt text](https://github.com/Saleemahmh/Routes/blob/master/src/main/resources/chennai/Chromepet/Amenitites%20and%20urban.jpg)
