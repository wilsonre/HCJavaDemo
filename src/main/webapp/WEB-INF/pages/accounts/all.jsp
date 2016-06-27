<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<title>ConnectDemoApp</title>

<link rel="stylesheet" href="/static/css/style.css" type="text/css"
	media="screen" title="no title">
<link rel="stylesheet" href="/static/css/purple.css" type="text/css"
	media="screen" title="no title">
<script src="/static/js/purple.js" type="text/javascript"
	charset="utf-8"></script>
</head>
<body>
	<header id="header" class="gradient-primary">
		<div class="container text-center">
			<div class="title">Account List</div>
		</div>
	</header>
	<div id="content" class="container">

		<div class="center">

			<h1>Listing Accounts from Salesforce Org</h1>

		</div>

		<br/> <br/>

		<div id="button">
			<a href="/accounts/new">Create New Account</a>
		</div>

		<br/> <br/>

		<table class="table">
			<thead>
				<tr>
					<th>Account Name</th>
					<th>Website</th>
					<th>City</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="account" items="${Accounts}">
					<tr>
						<td><a id="${account.id}"
							href="${rootURL}accounts/${account.id}.html">${account.name}</a>
						</td>
						<td><a id="website_${account.id}"
							href="http://${account.website}">${account.website}</a></td>
						<td>${account.billingcity}</td>
						<td class="text-center"><a id="show-${account.sfid}"
							class="fa fa-trash"
							href="${rootURL}contacts/account?accountid=${account.sfid}">Contacts</a></td>
						<td class="text-center"><a id="edit-${account.sfid}"
							class="fa fa-trash"
							href="${rootURL}${solo}accounts/edit/${account.id}.html">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
