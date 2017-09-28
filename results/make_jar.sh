#!/usr/bin/env bash

cd src
zip -r com.liferay.wedeploy.samples.portlet-1.0.0.jar *
mv com.liferay.wedeploy.samples.portlet-1.0.0.jar ../deploy/