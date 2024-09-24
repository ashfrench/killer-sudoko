# To Build and Run
```shell
..\gradlew clean build 
```

```docker
docker build -t sudoku_sovler .

docker run -p 8080:8080 sudoku_sovler
```

# Swagger Location
Swagger Location when running locally
http://localhost:8080/swagger-ui/index.html

## Plans

To create a spring boot app, with kafka and a database

Kafka will be used to show all the updates from a particular sudoku grid

Create a way to listen to a topic to get the updates 
