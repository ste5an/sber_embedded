<<<<<<< HEAD
Описание приложения:

Приложение упаковано в docker image.

Для удобства запуска используется embedded H2 Database.

Инструкция по установке: Для запуска приложения необходим установленный docker 

Команда для скачивания:

docker pull ste5an/docker-sber-app:sberapp

Команда для запуска:

docker run -p 8080:8080 ste5an/docker-sber-app:sberapp

Ссылка на Докер репозиторий:

https://hub.docker.com/r/ste5an/docker-sber-app

SQL DDL scripts:

CREATE DATABASE sbertestDB;

CREATE TABLE TEAM ( 
    id BIGSERIAL PRIMARY KEY NOT NULL, 
    name VARCHAR(100) NOT NULL, 
    squad_type VARCHAR(100) NOT NULL, 
    tag VARCHAR(100) NOT NULL 
);

CREATE TABLE EMPLOYEE ( 
    id BIGSERIAL PRIMARY KEY NOT NULL, 
    first_name VARCHAR(100), 
    last_name VARCHAR(100), 
    given_name VARCHAR(100), 
    position VARCHAR(100), 
    age int, 
    team_id bigint REFERENCES TEAM (id) 
);

Пример использования REST API

1. Создание команды: POST http://localhost:8080/rest/team/save

{
    "name": "C++",
    "type": "BackEnd",
    "tag": "CB01"
}

2. Создание нового employee с указанием teamName для привязки к нужной команде: POST http://localhost:8080/rest/employee/save

{
    "teamName": "C++", 
    "firstName": "Peter", 
    "lastName": "Levin", 
    "givenName": "D", 
    "position": "Middle C++", 
    "age": 34
}

3. Остальные команды должны быть интуитивно понятны для выполнения, но если возникнут вопросы, то буду рад ответить.
------------------------------------------------------------------
------------------------------------------------------------------

Swagger описание REST API http://localhost:8080/swagger-ui.html

------------------------------------------------------------------
------------------------------------------------------------------

TEAM COMMANDS
Save new team:
POST http://localhost:8080/rest/team/save

{
    "name": "C++",
    "type": "BackEnd",
    "tag": "CB01"
}

Find all teams:     GET http://localhost:8080/rest/team/teams 
Delete team by id:  DELETE http://localhost:8080/rest/team/delete/? 
Find team by id:    GET http://localhost:8080/rest/team/find/? 
Update team by id:  PUT http://localhost:8080/rest/team/update

------------------------------------------------------------------
------------------------------------------------------------------



EMPLOYEE COMMANDS

Save new employee:      POST http://localhost:8080/rest/employee/save 

{ 
    "teamName": "C++",
    "firstName": "Peter",
    "lastName": "Levin",
    "givenName": "D",
    "position": "Middle C++",
    "age": 34 
} 

Find all employees:     GET http://localhost:8080/rest/employee/employees 
Delete employee by id:  DELETE http://localhost:8080/rest/employee/delete/{id} 
Find employee by id:    GET http://localhost:8080/rest/employee/find/{id} 
Update employee by id:  PUT http://localhost:8080/rest/employee/update
=======
CREATE DATABASE sbertestDB

CREATE TABLE TEAM
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    name       VARCHAR(100) NOT NULL,
    squad_type VARCHAR(100) NOT NULL,
    tag        VARCHAR(100) NOT NULL
);
--------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------
CREATE TABLE EMPLOYEE
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(100),
    last_name  VARCHAR(100),
    given_name VARCHAR(100),
    position   VARCHAR(100),
    age        int         ,
    team_id    bigint REFERENCES TEAM (id)
);
--------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------
Инструкция по запуску и тестированию приложения:
Для тестирования запросов использовать POSTMAN 

1. Создать таблицу TEAM, затем создать таблицу EMPLOYEE

2. Выполнить запрос POST в postman для team:
SAVE TEAM:			http://localhost:8080/rest/team/save
{
        "name": "C++",
        "type": "BackEnd",
        "tag": "CB01"
	}

3. Далее добавим нового EMPLOYEE в нужную команду(TEAM), указав teamName для привязки к нужной команде:
{
        "teamName": "C++",
        "firstName": "Peter",
        "lastName": "Levin",
        "givenName": "D",
        "position": "Middle C++",
        "age": 34
    	}
 
4. Остальные команды должны быть интуитивно понятны для выполнения, но если возникнут вопросы, то буду рад ответить.

----------------------------------------------------------------------------------------------
TEAM COMMANDS
----------------------------------------------------------------------------------------------
SAVE TEAM:			http://localhost:8080/rest/team/save
{
        "name": "C++",
        "type": "BackEnd",
        "tag": "CB01"
}

GET ALL TEAMS:	 		http://localhost:8080/rest/team/teams
GET TEAM BY ID:			http://localhost:8080/rest/team/find/?
UPDATE(PUT) TEAM BY ID: 	http://localhost:8080/rest/team/update
DELETE TEAM BY ID:		http://localhost:8080/rest/team/delete/?
----------------------------------------------------------------------------------------------
EMPLOYEE COMMANDS
----------------------------------------------------------------------------------------------
SAVE EMPLOYEE:			http://localhost:8080/rest/employee/save
{
        "teamName": "C++",
        "firstName": "Peter",
        "lastName": "Levin",
        "givenName": "D",
        "position": "Middle C++",
        "age": 34
    }
GET ALL EMPLOYEES: 		http://localhost:8080/rest/employee/employees
DELETE EMPLOYEE BY ID: 		http://localhost:8080/rest/employee/delete/?
GET EMPLOYEE BY ID:		http://localhost:8080/rest/employee/find/?
UPDATE(PUT) EMPLOYEE BY ID: 	http://localhost:8080/rest/employee/update

























>>>>>>> b0ba126... Initial commit
