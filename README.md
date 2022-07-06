# Springboot Application / Back end

This application is a Pet Play Date Dog application where dog owners can access the website, check dogs that are avilabe to hang out with and send them a message to set up a time to meet and play. Also, users can check available pet Toys and buy them using PayPal API. 

## Technologies:

* Springboot
* Intellij IDE
* Maven
* Java corretto 17
* Spring JPA
* MariaDB / HeidiSQL
* Spring Security JWT
* Postman
* Heroku
* AWS S3
* Docker

## WorkFlow:

### Admin:
* Homepage
* Login 
* Add/Delete/Update dogs

### Customer / User:
* Check Available dogs
* Filter to check availabe dogs based on breed, gender, and city location
* Send message to dog
* Check available toys
* Pay for a toy

## Database Design:

![petfundate-ER drawio](https://user-images.githubusercontent.com/56841959/177400360-8bf0b619-d9a7-423d-8554-e99470172e83.png)

## Application Architecture:

![image](https://user-images.githubusercontent.com/56841959/177400969-3d6bf54d-ad83-4c35-b11d-7b4fa86ee927.png)


## Security:
* JWT: Jason Web Token 

![login](https://user-images.githubusercontent.com/56841959/177439994-5c2c0b24-3965-4edc-b942-b5c9266049a2.JPG)
                           

## Testing:
* JUnit 
* AssertJ
* Dependencies: H2 Database and Test starter package that was added to pom.xml by spring initializer when we created our project
      
      <dependency>
          <!--Starter test generated with Springboot project-->
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-test</artifactId>
          <scope>test</scope>
      </dependency>

      <dependency>
         <!--H2 database will be used only for running tests-->
         <groupId>com.h2database</groupId>
         <artifactId>h2</artifactId>
         <scope>test</scope>
      </dependency>
      
## Deployment:
Coming soon...Heroku + Docker

## Application Demo:
Coming soon...
