FROM hotswapagent/tomee

# Create project directory (workdir)
RUN mkdir -p /app
WORKDIR /app
RUN mkdir -p /extra_class_path


# Add jar to WORKDIR
ADD target/quickstart-spring-java-0.0.1-SNAPSHOT.jar .

ENV JAVA_OPTS="-XXaltjvm=dcevm -agentlib:jdwp=transport=dt_socket,server=y,address=20008,suspend=n -javaagent:/opt/hotswap-agent/hotswap-agent.jar=extraClasspath=/extra_class_path,autoHotswap=true"

EXPOSE 8080
EXPOSE 20008

ENTRYPOINT java $JAVA_OPTS -jar quickstart-spring-java-0.0.1-SNAPSHOT.jar