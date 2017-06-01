# oacore4j

[![Build Status](https://travis-ci.org/oacore/oacore4j.svg?branch=master)](https://travis-ci.org/oacore/oacore4j)
[![Gitter chat](https://badges.gitter.im/org.png)](https://gitter.im/oacore-mozsprint17/Lobby)

A Java client for the [CORE API](https://core.ac.uk/docs/), based on [Retrofit 2](https://github.com/square/retrofit).

[CORE](https://core.ac.uk)’s mission is to aggregate all open access research outputs from repositories and journals worldwide and make them available to the public. In this way CORE facilitates free unrestricted access to research for all. We are currently making avaialble 70 million of research outputs metadata and 7 million full text papers. We are looking for devs, designers, data scientists enthusiastic about facilitating the access to research to the world.


## Mozilla Global Sprint '17
This repository is one of our project for the Mozilla Global Sprint '17. 

![Global Sprint](https://cloud.githubusercontent.com/assets/617994/24632585/b2b07dcc-1892-11e7-91cf-f9e473187cf7.png)

### How to contribute
We need help to implement our Java API client. A full Swagger documentation is available at [https://core.ac.uk/docs](https://core.ac.uk/docs),
while you can find a usage example [here](src/test/java/uk/ac/core/oacore4j/articles/ArticlesServiceTests.java).
Pull requests and feedback through the issues panel are highly encouraged and appreciated.

We defined a small workflow process to implement further methods in the client. These steps are suggestions, but it should help :)

1. Create a retrofit-like method in a Retrofit-like interface. For example to map a request on the API like: 
    ```http 
    GET /articles/get/{coreId} 
    ```
   The Retrofit interface definition will be:
   
    ```java 
    Call<Article> getArticleById(@Path(CORE_ID) Integer coreId, @QueryMap Map<String, Object> options); 
    ```
   [This is an example of the interface for the Articles API](https://github.com/oacore/oacore4j/blob/master/src/main/java/uk/ac/core/oacore4j/articles/ArticlesService.java)

2. If you need to generate any Java Object to handle request or response, we suggest you to get a complete JSON object from the API (you need a valid CORE article ID? Use 42) and then submit it to [jsonschema2pojo](http://www.jsonschema2pojo.org/) using the Jackson 2.x annotation style. You should be able to generate a POJO (nearly) ready to be used in the client. 

3. Write tests for it, you can find some tests [examples here](https://github.com/oacore/oacore4j/blob/master/src/test/java/uk/ac/core/oacore4j/articles/ArticlesServiceTests.java).
To run them locally, just type:
    ```maven
    mvn test -DapiKey={YOUR_API_KEY}
    ```

Help us making the scientific world openly accessible by everyone!
