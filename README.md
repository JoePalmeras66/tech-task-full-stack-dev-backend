# Tech Task D3 Cloud: Backend

Spring-Boot Application for crawling periodically JSON data from https://randomuser.me/api and store the fetched data in PostgresDB. 

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [gradle](https://docs.gradle.org)
- [docker](https://docs.docker.com/get-docker/)
- [docker-compose](https://docs.docker.com/compose)

## Getting Started

For start Postgres Database run 

```
docker-compose up
```

IMPORTANT: First time you running postgresDB docker-compose you have to setup the tables. See therefore Instroctions under [README_INITIAL_SETUP.md](README_INITIAL_SETUP.md)

Check docker images:

```
docker images

REPOSITORY       TAG       IMAGE ID       CREATED      SIZE
postgres         latest    4c6b3cc10e6b   2 days ago   379MB
dpage/pgadmin4   latest    7ac3e08c2412   9 days ago   358MB
```

Verify container running
```
docker ps

CONTAINER ID   IMAGE            COMMAND                  CREATED        STATUS         PORTS                           NAMES
79ab86583b10   dpage/pgadmin4   "/entrypoint.sh"         20 hours ago   Up 5 seconds   443/tcp, 0.0.0.0:5050->80/tcp   pgadmin_container
8073210961f2   postgres         "docker-entrypoint.s…"   20 hours ago   Up 7 seconds   0.0.0.0:5432->5432/tcp          postgres_container
```

## Build & Run Spring-Boot Application

```
gradlew clean build bootRun
```

## Stop docker container

```
docker-compose down
```

### References

* [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker/)
* [RUNNING SPRING BOOT IN A DOCKER CONTAINER](https://springframework.guru/running-spring-boot-in-a-docker-container/#comment-2306)
* [Using Docker containers for your Spring boot applications](https://g00glen00b.be/docker-spring-boot/)
* [Dockerize Spring Boot Application](https://medium.com/sudharao/dockerize-spring-boot-application-deploy-spring-boot-application-to-docker-containerize-spring-e039a1aa743a)
* [Dockerize a Spring Boot application](https://thepracticaldeveloper.com/2017/12/11/dockerize-spring-boot/)
* [Dockerizing a Spring Boot Application by baeldung](http://www.baeldung.com/dockerizing-spring-boot-application)
* [Docker Documentation](https://docs.docker.com/)





