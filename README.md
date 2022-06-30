# test-ais
AUTOMATIC IRRIGATION SYSTem 
# Prerequisites

In order to work with this project we need to previously install the following tools and plugins:

* Java 8 - https://www.oracle.com/java/technologies/downloads/#java8
* Maven - https://maven.apache.org/install.html
* MYSQL DB instance running on localhost wit default Port you can check (application.properties)
* no node to create the DB the application will automatically create the DB if not exist in order to application start correctly without disabled Spring Boot fail-fast feature
* i usually use the wireMock for this i create simple mock controller instead to avoid running jar to simulate sensor 

### Compile and package the project
First we need to clone the project 
```bash
git clone https://github.com/ahmedelbatrawy123/test-ais.git
```

After that, we need to compile
```bash
mvn clean install
```



## Available API services


#### CropAPI to create Crop

This API allows to create Crop

#### PLOT API

This API allows to create a new PLOT ,Update existing plot,Delete a plot,Get existing plot by plot id,Get list of all existing plots

#### COORDINATES API

This API allows to Get list of plot coordinates,Assign Coordinates to a plot, removes existent before coordinates.

#### MOCK API
TO simulate sensor and also avoid running mocking server to simple running APP
## Usage

## NOTES
* we use layered architecture instead of clean & Hexagonal Architecture so the domain is not isolated from other dependancy
* we communicate with a sensor  in a synchrony way or even reactive
* Didn't use Resilienc4j lib to achive Circuit breaker, Retry ,Rate limiter ,Bulkhead ,Time Limiter
* missing some validation
* Didn't use discovery server to allocate sensor service make it static
* Didn't write test most of test are integration test 
* simulate alert system by log message to avoid use mail server.

