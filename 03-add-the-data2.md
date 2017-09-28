# Data Service (Alternative)

We have seen one way of adding the service, though the UI. We could do the very same thing though the CLI!

It is easy: create a new folder for Data service and add `wedeploy.json` with the following content:

```json
{
    "id": "db",
    "image": "wedeploy/data:0.0.1"
}
```

The difference now is that we specified a predefined WeDeploy service image. As before, this service can be deployed with:


```shell
we deploy -p devcon
```

Head to the [wedeploy page](http://wedeploy.com) and see how it is being deployed, until it is ready.
