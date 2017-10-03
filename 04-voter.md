# Voter App

We are going to enhance the Java service and to make an app out of it. It is going to be a voting app, where user can choose if he likes on or the another option. We will need the following endpoints:

+ `/voteFor[cat|dog]` - action to vote for a cat or a dog.
+ `/votes` - action that return votes count.
+ `index.html` - simple html page with two buttons, that triggers the voting.

Our Java application is going to store data in the data service, created in previous step. We will use the collection name: `devcon` and the key `votes`. For the purpose of this demo, our collection is going to have just this simple record, with predefined id.

## Local Development

During our local development, we can simply use our deployed data service! No need to install anything locally, just use the address of the service on wedeploy.io!

This is super convenient, as we don't have to change a thing for the deployment!

Let' develop the requirements.

## WeDeploy API

Since data is a remote service, we access it via HTTP. Sure, you can use any HTTP client that you like; but why not try to use our own `WeDeploy.api-java` client? Not only is it a HTTP client, but it has some additional functionalities to make your work easier.

---

After we are done with coding, check how the application is working:

```shell
./gradlew build run
open http://localhost:8080
open http://localhost:8080/votes.json
```

If everything is OK, let's deploy!

## Deploying

Redeploying a service is simple, just deploy it again:


```shell
cd voter
we deploy -p devcon
```

Once our service is deployed (check the [wedeploy project's page](http://wedeploy.com)), let's see how it works live:

```shell
open https://voter-<your_handle>devcon.wedeploy.io
open https://voter-<your_handle>devcon.wedeploy.io/votes.json
```

We deployed a working app!!! :)

---

[continue...](05-liferay.md)
