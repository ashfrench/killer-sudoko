# To Build and Run
```shell
.\..\gradlew clean build 

docker build -t sudoku_sovler .

docker run -p 8080:8080 sudoku_sovler
```

# Swagger Location
Swagger Location when running locally
http://localhost:8080/swagger-ui/index.html
