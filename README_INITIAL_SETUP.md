


>***Initial SetUp***
>

1. **Run docker-compose.yaml**
   start postgres-db and pgAdmin instance in docker

2. **Prepare Sql-Script "create.sql"**

   gradlew build

   Produces "create.sql" file. Append semicolon ';' at every line end in "create.sql"-file.
3. **pgAdmin create connection to docker postgres-db**

   To create a connection to postgres-db in docker-container with pgAdmin you need the ip-address of the postgres docker container instance.

   First to grap the containerId run:

   docker ps

To get the **ip-address** of postgres docker container run:


docker inspect "containerId"

 Use **ip-address** from the console output for pgAdmin Connection

4. **Run Sql-Scripts from "create.sql" in pgAdmin**

In pgAdmin you can execute the previousely generated and prepared "create.sql"-script. Please first run "create table" commands without foreign keys. After that run the remaining "create table" commands and lastly the "alter table" commands


> Written with [StackEdit](https://stackedit.io/).
