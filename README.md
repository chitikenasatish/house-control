# Room Control System

Room State not persisted in DB , But cached in Concurrent Map .
How to run from command line
  
    java -jar target/house-control-0.0.1-SNAPSHOT.war

Default Port configured 8090 .

## House Control Board will be available at

    http://localhost:8090/index.html

## Technologies and Frameworks Used
1. Spring Boot as Embed Tomcat HttpServer to handle multiple requests and default HTTP 1.1 maintain connection keep-alive with the server.  15 sec connection timeout. If the request comes from different hosts better to keep the connection timeout less, If requests comes from the same host we can increase the timout to achieve good TPS numbers.
2. JQuery to prepare the Control Board and make backend Rest calls to persist the room Change events like temprature , Light On/off and Curtain status.

**To get (GET Mthod )the list of available Rooms with the status , or to know the status of single room with roomid**

    http://localhost:8090/v1/rooms
    http://localhost:8090/v1/rooms/{id}


Initial Rooms details populated from JSON file resources/home.json

**To Update (PUT Request) the Room Status for temprature change light changes.**

    http://localhost:8080/v1/rooms/{id}
    Request for temprature change.
    {"temperature" : 75}

**Temp/Light Success Change Event Listener to know the change Status (subscribe) **

       $(document).on("HouseLightAndCurtainEvent", function (evt) { });
       $(document).on("TempChangeEvent", function (evt) { });

       Listen to Custom Events triggered upon temp change and Light switch events.


**Temp/Light send Trigger event to be consumed by suscribers (publish) **
       $.event.trigger({
                      type:    "TempChangeEvent",
                      message: "Initialize TempColor",
                      roomid:    obj.id,
                      color : obj.temperature
                    });

## To Build
        mvn clean install

## Code format:

## To DO :
1. Integrating with DB ,
2. Caching Layer
3. LOGGING
4. Exception handling
5. Unit testcases and Unit Test coverage
6. CICD

