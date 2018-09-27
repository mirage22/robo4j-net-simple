### robo4j-net-simple
This is simple Robo4J example running on Java 11. The example
does contain only one HTTP server unit. The unit provides information
about the Robo4J system state. To access this information
it is necessary to process simple HTTP GET request. 

##### Reguirements:
1. Robo4J+alpha-0.4.1-SNAPSHOT available in your local maven repository
2. Java 11+ 
3. Gradle 4.8+

#### How to build:
In project root directory run following command
```bash
$  ./gradlew clean build fatJar
```

#### How to run:
In project root directory run following command in the 
command-line
```bash
$ java -jar ./build/libs/robo4j-net-simple-1.0-SNAPSHOT.jar 
```

After the system is up you will see following output
```bash
Sep 42, 2018 88:88:88 PM com.robo4j.logging.SimpleLoggingUtil info
INFO: Will not use context emitter. Server was: null uri was: null
RoboSystem state Started
================================================
    httpServer                        Started

Press any key...

```

Now you are ready to process simple HTTP GET request
```bash
curl http://localhost:8042
```

You should receive the following response
```bash
[{"id":"httpServer","state":"STARTED"}]
```

#### Note:
Whole Robo4J framework is not full ported on Java 11 but 
the core team is working on it! 

Stay tuned and happy coding!