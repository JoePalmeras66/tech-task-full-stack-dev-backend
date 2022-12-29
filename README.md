# Tech Task D3 Cloud: Backend

Spring-Boot Application for crawling periodically JSON data from https://randomuser.me/api and store the fetched data in PostgresDB.

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [gradle](https://docs.gradle.org)
- [docker](https://docs.docker.com/get-docker/)
- [docker-compose](https://docs.docker.com/compose)

## Getting Started

### Build docker image

```
gradlew bootBuildImage
```

### Run Application

```
docker-compose up -d
```

IMPORTANT: First time you running postgresDB docker-compose you have to setup the tables. See therefore Instructions under [README_INITIAL_SETUP.md](README_INITIAL_SETUP.md)

### Check docker images

```
docker images

REPOSITORY                            TAG        IMAGE ID       CREATED        SIZE
paketobuildpacks/run                  base-cnb   e06d1d37657c   19 hours ago   87MB
postgres                              latest     4c6b3cc10e6b   8 days ago     379MB
dpage/pgadmin4                        latest     7ac3e08c2412   2 weeks ago    358MB
joepalmeras66/tech-task-dev-backend   latest     1c33e46eb64d   42 years ago   307MB
paketobuildpacks/builder              base       c3549f435e8e   42 years ago   1.34GB
```

### Verify container running
```
docker ps

CONTAINER ID   IMAGE                                        COMMAND                  CREATED          STATUS          PORTS                           NAMES
b569e4aa4400   joepalmeras66/tech-task-dev-backend:latest   "/cnb/process/web"       33 seconds ago   Up 29 seconds   0.0.0.0:8080->8080/tcp          tech-task-full-stack-dev-backend-tech-task-dev-backend-1
1134aec271ec   dpage/pgadmin4                               "/entrypoint.sh"         33 seconds ago   Up 29 seconds   443/tcp, 0.0.0.0:5050->80/tcp   pgadmin_container
45c1771b81f8   postgres                                     "docker-entrypoint.s…"   33 seconds ago   Up 31 seconds   0.0.0.0:5432->5432/tcp          postgres_container
```

### Shut down docker container's

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





