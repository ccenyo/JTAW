# tiny.cc api client built in java

## With the release of the V3 of their API, this wrapper does not work anymore.

This is a simple java client for the [tiny.cc api](https://tiny.cc/api-docs). It is:

* small
* easy to use
* licensed under the apache license 2.0

# Get Involved!

the project just started, there are only few methods added. if you want to help me, feel free to fork the repository, add your feature and send me a pull request. Thanks


## STEP 1: Get An OAuth Access Token (from tiny.cc)

https://tiny.cc/api-docs

## STEP 2: How to install

```
	<dependency>
		<groupId>net.cenyo.tiny</groupId>
		<artifactId>JTAW</artifactId>
		<version>1.0.3</version>
	</dependency>
````		


## STEP 3: Get Cracking (Fluent Builders)

The basic principle is simple: You create a TinyClient with your access token. This is your factory and can be reused and passed around instead of passing around the access token String. Let the `BitlyClient` create a `RequestBuilder` for you and configure it, then make the call to bitly and work with the response. Simple, right? So here goes:

```
TinyClient client = new TinyClient("... access token ...");
		Response<ShortenResponse> resp = client.shorten() //
			.setLongUrl("https://www.example.com/tinycc-api-client-test") //
			.call();
```


## STEP 4: Working With The Response Object

The `Response<T>` is a container that contains 4 important fields:

* errorCode
* errorMessage
* statusCode
* results

The `results` field contains the actual response information of type `T`. It is possible, that the `results` field is `null`. As of now, it is your obligation to check the `statusCode` and act accordingly.
