<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<p>
	<liferay-ui:message key="wedeploy_portlet_JSPPortlet.caption" />
</p>

<script>
    define._amd = define.amd;
    define.amd = false;
</script>

<script src="https://cdn.wedeploy.com/api/2.3.1/wedeploy.js"></script>
<h1>VOTING RESULTS</h1>

<style type="text/css">
	.result {
		font-size: 2em;
		color: #ff4466;
		background-color: #feecde;
		padding: 20px;
		margin: 10px;
	}
</style>

<div id="cats" class="result"></div>
<div id="dogs" class="result"></div>

<script>
document.addEventListener("DOMContentLoaded", function(event) {
	WeDeploy
	  .url('https://db-devcon.wedeploy.io/devcon/votes')
	  .get()
	  .then(function(response) {
	  		body=eval(response.body());
			var theDiv = document.getElementById("cats");
	        theDiv.innerHTML = '<b>CATS: ' + body["cats"] + '</b>';
	        theDiv = document.getElementById("dogs");
	        theDiv.innerHTML = '<b>DOGS: ' + body.dogs + '</b>';
	  });
});

define.amd = define._amd;
</script>