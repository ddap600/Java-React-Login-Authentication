##About

This is a small Spring application, created to play around with some of the Spring Security features.

Currently, when booted up, it will create two roles, ADMIN and USER, and one user for each.

It has endpoints to test the login for each of these, that will return a token.

That token can be used on the auth test endpoints to test authentication and role based logins.

##Installation

If  you are cloning you will also need to setup a MySQL database or any other database connection of your choosing.

If  you are using IntelliJ, open this project by selecting pom.xml. This should ensure that IntelliJ treats this is as a Maven project.

Lombok will also require you to enable annotation processing.
Also make sure Lombok plugin installed and enabled.

Since it's a Maven project, 'mvn clean install' is a useful command.

##Backend

Java / Spring

Used Spring Intializr to kickstart the project with following dependencies:

Spring Web
Spring Data JPA
MySQL Driver
Spring Security
Lombok

Added later:
H2 Database
H2 Console

JWT API
JWT Impl
JWT Jackson

The database was changed to use MySQL in the beginning stages.
The config for H2 is still present, but commented out.

##Note on Config

Spring Security has Role based authentication.
From my understanding this requires roles to be explicitly "ROLE_[name]".
For this applications all roles are setup with just [name].

For example instead of "ADMIN_ROLE", we have "ADMIN".

So in the security config hasAuthority is used instead of hasRole.

We could just change roles to fit the naming convention Spring wants, but this also works for now. 

