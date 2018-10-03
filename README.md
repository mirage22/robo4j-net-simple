### robo4j-net-simple
This is a simple Robo4J example running on Java 11. The example
does contain only one HTTP server unit. The unit provides information
about the Robo4J system state. To access this information
it is necessary to process simple HTTP GET request. The Example also shows 
two different approaches of **configuring** the Robo4J system: 
1. **Declarative**   (DeclarativeMain.java)
2. **Programmatic**  (ProgrammaticMain.java)

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
In the project root directory run following the command in the 
command-line
```bash
$ java -jar ./build/libs/robo4j-net-simple-1.0-SNAPSHOT.jar 
```

After the system is up you will see the following output
```bash
Sep 42, 2018 88:88:88 PM com.robo4j.logging.SimpleLoggingUtil info
INFO: Will not use context emitter. Server was: null uri was: null
RoboSystem state Started
================================================
    httpServer                        Started

Press any key...

```

Now you are ready to process the simple HTTP GET request
```bash
curl http://localhost:8042  //Declarative
curl http://localhost:8042  //Programmatic

```

You should receive the following response
```
[{"id":"robonetSystem1","state":"STARTED"},{"id":"http_server","state":"STARTED"}]  //Declarative
[{"id":"robonetSystem2","state":"STARTED"},{"id":"http_server","state":"STARTED"}]  //Programmatic
```

#### Important note:
The whole Robo4J framework is still not fully ported on Java 11 but 
the core team is working on it! 

Stay tuned and happy coding!