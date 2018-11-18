FROM maven:latest
VOLUME /tmp
ADD /src /src
ADD pom.xml pom.xml
ENTRYPOINT ["mvn","clean","spring-boot:run"]
