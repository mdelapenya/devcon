#!/usr/bin/env bash

rm -f deploy/com.liferay.wedeploy.samples.portlet-1.0.0.jar
cd src
zip -r com.liferay.wedeploy.samples.portlet-1.0.0.jar *
mv com.liferay.wedeploy.samples.portlet-1.0.0.jar ../deploy/