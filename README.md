#  SUPPORTING PETS 

<center><img src="http://www.graphicmania.net/wp-content/uploads/2013/07/dog-wallpaper.jpg"></center>

This repository presents the development of a REST API project with Spring Boot to manage donations to pets.




# Running the project

To run the project on the terminal, type the following command

```
mvn spring-boot:run
```

After executing the above command, you can access the following addresses and view the project:

```
http://localhost:8080/api/v1/people
http://localhost:8080/api/v1/animal
http://localhost:8080/api/v1/donation
```

The system is also available online through the Heroku platform:

```
https://supporting-pets.herokuapp.com
```

Using this API you are able to:
- Find all people, animals or donations
- Find by ID
- Create new records
- Update and delete records by ID.


# Entity-Relationship Diagram 

The diagram below illustrates the entities of the system and their relationships.

<center><img src="https://i.ibb.co/82KmgDh/er-diagram.png"></center>


A person can donate to many animals, and an animal can receive many donations. Besides, a person can register many pets (Animal) to receive donations.
