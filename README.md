# Foodzilla Backend ![Build Status](https://travis-ci.org/leite08/foodzilla-backend.svg?branch=master)
## Java and String Boot

This application serves the API of Foodzilla, offering endpoints to be called by the frontend.

Built for the VanHack Week Nov/2017:
http://www.vanhack.com/week/

Basic technologies:

**Java**, Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible.
 
**Spring Boot**, Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

**Maven**, Apache Maven is a software project management and comprehension tool.

## Installation

Install Java 8 JDK:

    http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Install Maven:

	https://maven.apache.org/install.html
	    
After forking and cloning the repo:

    cd foodzilla-backend
    mvn install
    cd target/deploy/
    ./start.sh

Will start the application in background with logs on file.

To watch the logs execute this on the deploy folder: `./logs.sh`

## Team

- Otávio Soares - https://github.com/otaviosoares
- Rafael Leite - https://github.com/leite08
- Sohel Almozaini - https://github.com/i-Sohel


## Tech Stack

- Java
- Spring Boot
- ...


## License

Licensed under the [MIT](http://www.opensource.org/licenses/mit-license.php)  license.