# quickstart-spring-java

Spring java quickstart  for [DevSpace](https://github.com/devspace-cloud/devspace)

Hot reload by [HotswapAgent](https://github.com/HotswapProjects/HotswapAgent)


# Setup

## Edit pom.xml

``` 
<dependency>
    <groupId>org.hotswapagent</groupId>
    <artifactId>hotswap-agent-spring-plugin</artifactId>
    <version>1.4.0</version>
</dependency>
```

## Edit hotswap-agent.properties

```
extraClasspath=/extra_class_path
autoHotswap=true
```

## Dockerfile

```
FROM hotswapagent/tomee

# Create project directory (workdir)
RUN mkdir -p /app
WORKDIR /app
RUN mkdir -p /extra_class_path


# Add jar to WORKDIR
ADD target/quickstart-spring-java-0.0.1-SNAPSHOT.jar .

ENV JAVA_OPTS="-XXaltjvm=dcevm -agentlib:jdwp=transport=dt_socket,server=y,address=20008,suspend=n -javaagent:/opt/hotswap-agent/hotswap-agent.jar"

EXPOSE 8080

ENTRYPOINT java $JAVA_OPTS -jar quickstart-spring-java-0.0.1-SNAPSHOT.jar
```

## Init devspace

```
devspace init
```


## Edit devspace.yaml

```
  sync:
  - imageName: default
    localSubPath: ./target/classes
    containerPath: /extra_class_path 
    excludePaths:
    - devspace.yaml
```

# RUN

## Build and deploy

```
mvn package -DskipTests=true
mvn deploy
mvn dev
```

## Modify RootController.java and save

See the magic.

