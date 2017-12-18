##How to deploy locally
 - checkout and import this project as gradle project in eclipse/intellij
 - you must have mongo installed as it is backed by mongo-db
 - change the mongo credentials in application-local.properties 
 - got to root folder and run the following command:
  - `gradle clean bootRun -Dspring.profiles.active=local`
 - you can debug this application on port 5050 (configurable in build.gradl)


##GraphiQL
 - Open http://localhost:9090/graphiql in your browser to access GraphiQL


##APIs
 - Import this postman collection for all the dummy APIs: https://www.getpostman.com/collections/be1d19307f5c34c13f5d