# Simple Rest Service that provides Chuck Norris :)

you get 2 ressources

| resource                                    | usage                               | description                         | 
|---------------------------------------------|-------------------------------------|-------------------------------------|
| localhost:8080/chucknorris/fact             | GET localhost:8080/chucknorris/fact | returns a random chuck norris fact as string|
| localhost:8080/chucknorris/roundhouseaction | POST localhost:8080/chucknorris/roundhouseaction Content-Type: application/json { "action": "SUCCESS" } | returns a chuck norris image for SUCCESS, ALERT, FAIL as the jenkins plugin shows |

for more examples see: [requests.http](./requests.http)
 
