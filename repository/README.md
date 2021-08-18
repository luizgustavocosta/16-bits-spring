# Endpoints

http://localhost:8080/api/v1/jpa/movies?page=2&size=3

SELECT * FROM MOVIES where year = '3000'

Natural order is by name

GET curl "http://localhost:8080/api/v1/jpa/movies?page=1&size=20&sortBy=year"

POST curl -d '{"name":"Luiz", "year":"3000"}' -H "Content-Type: application/json" -X
POST http://localhost:8080/api/v1/jpa/movies

PUT curl -d '{"id":"66f5a5df-133e-4880-a39d-3340296c4715","name":"Luiz Costa", "year":"3000"}' -H "Content-Type:
application/json" -X PUT http://localhost:8080/api/v1/jpa/movies
curl -d '{"id":"66f5a5df-133e-4880-a39d-3340296c4715A","name":"Luiz Costa", "year":"3000"}' -H "Content-Type:
application/json" -X PUT http://localhost:8080/api/v1/jpa/movies

DELETE curl -H "Content-Type: application/json" -X
DELETE http://localhost:8080/api/v1/jpa/movies/0a64f4e9-894a-4fe5-853f-a2d8738432e7LC

https://www.conventionalcommits.org/en/v1.0.0/#specification