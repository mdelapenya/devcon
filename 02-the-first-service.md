# The First Service

We are going to build a simple Java application as our first WeDeploy service.
It's a simple hello-world Spring Boot application.


## Project creation

First thing first - we need a project. Go to [wedeploy.com](http://wedeploy.com) and add a new project.

We are going to name the project as: `devcon`.

However, your project name must be unique, so you can not use the very same name. We propose to follow this pattern for naming the project: `devcon-<your_handle>`.


## The First Java service

Let's now prepare a Java service locally. Create a root folder for the project.


```shell
mkdir devcon
```

To save some time, we already have a boilerplate project ready! Checkout it:

```bash
git clone --depth 1 https://github.com/wedeploy/boilerplate-java.git voter
```

Like said above, this is a simple Java project, based on Spring Boot. There is nothing WeDeploy related in it. You can build it and run it like any other java application:


```bash
cd voter
./gradlew build
./gradlew run
```

The application should be running at port `8080`. Check it in your browser.


## WeDeployment!

It's time to deploy our Java service!

Edit or add `wedeploy.json` file in the service's folder (`voter`):


```json
{
  "id": "voter"
}

```

This file is NOT mandatory; we have added it just to get familiar with it. It is used for WeDeploy deployment configurations. In this example, we just set the service name (`id`).


Deployment is super easy with the WeDeploy CLI:


```bash
cd voter
we deploy -p devcon
```

Go to [wedeploy.com](http://wedeploy.com) and check what's happening!
