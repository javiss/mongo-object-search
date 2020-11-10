#Assignment

Spring REST app that allows to search by date or text poll objects in a mongo database.

## To run it in a container

Run

`$ docker-compose -f docker/docker-compose.yaml up`

Wait :)

## To run it in locally

Run these two docker containers defined in `docker-compose.yaml`

`mongo`

`mongo_seed`

Then run the app

`mvn clean install spring-boot:run`


## To use it
There is only one endpoint.

#### Search by date range

`localhost:8080/polls/?fromdate=2017-03-29&untildate=2020-03-11`

#### Search from date

`localhost:8080/polls/?fromdate=2017-03-29`

#### Search until date

`localhost:8080/polls/?untildate=2020-03-11`

#### Text search

`localhost:8080/polls/?text=doo`

#### Text search with date range
Not implemented

`localhost:8080/polls/?fromdate=2017-03-29&text=doo&untildate=2020-03-11`


## Why did I used 'x'

- `Lombok`: One of the quality of life libs that I like so I don't need to deal with accessors and constructors.
- `mapstructs`: Makes the mappings easy, especially for complex and similar objects where you can use listener annotation for the mapping hooks (`@BeforeMapping`, `@AfterMapping`,...). What I don't like about it is that you can't see the result until the app is compiled and you lose the type checking at the time of writing the coded because you're writing strings.
- `spring data`: Provides many things but the most useful for me is `CrudRepository`, unless you want to write complex queries most CRUD operations are working out of the box.
- `swagger with open-api generator`: Easy to define API's and code generation, with the swaggerfile that you use to develop the real service you could create a quick nodejs mock server that generates the JS objects to be used in the FE.
- `slf4j`: Easy to use logging.
- `mongo`: I used an nonSQL db because for this API a relational db wasn't needed.
- `mockito`: Super easy framework for testing.
- `spring boot starters`: Reduces the boilerplate and simplifies the spring dependencies.
- `guava`: Another quality of life libs, preconditions make the code more readable.

## If had more time...

- Text search is just a `contains`, with more time I would have implemented full text search and configure it according to the locale from the UI.
- I could have implemented text search with date range by filtering by date and then find the text in the business logic but that should be executed in the db.
- Response error codes, at this time you get a `400` and that's it, would be nice for the API user to know why the input is invalid.
- Integration tests with a real DB.
- Health endpoints for monitoring and deploy like spring actuator.
- Deploy to heroku