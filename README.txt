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

