
This is the source code for url shortener made by ZivKaZiv

How to run it :

```sh
## build project on the root
mvn clean
mvn compile
mvn install

## Run redis locally, or update the connection string

## run the redirect service
NOTE: Currently it runs only on Intellij - Maven problem
 
## run the shortner service
NOTE: Currently it runs only on Intellij - Maven problem
  
```

Once all the services are up, the following URLs will be available

Address | Description
--- | ---
http://localhost:8082/<id> | redirect service - GET
http://localhost:8083/url | url shortener service - POST send in body ShortenUrl with url like {"url":"http://www.ynet.com"}


ShortenUrl object
```sh
{
    "id": "c15be6d9",
    "url": "http://www.ynet.com",
    "createTimestamp": 1513693181426,
    "returnedUrl": "http://localhost:8083/c15be6d9"
}
```

