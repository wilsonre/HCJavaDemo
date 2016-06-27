<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<title>Contacts</title>

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
			<div class="title">Contact List</div>
		</div>
	</header>
	<div id="content" class="container">
<div class="left">		<div id="button">
			<a href="/accounts">Back</a>
		</div>
</div>
		<div class="center">

			<h1>Listing Contacts for Account: ${account.name}</h1>

		</div>

		<br/> <br/>

		<div id="button">
			<a href="/contacts/new">Create New Contact</a>
		</div>

		<br/> <br/>

		<table class="table">
			<thead>
				<tr>
					<th>Contact Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="contact" items="${Contacts}">
					<tr>
						<td><a id="${contact.id}"
							href="${rootURL}contacts/${contact.id}.html">${contact.firstname} ${contact.lastname}</a>
						</td>
						<td><a id="email_${contact.id}"
							href="mailto://${contact.email}">${contact.email}</a></td>
						<td>${contact.phone}</td>
						<td class="text-center"><a id="show-${contact.sfid}"
							class="fa fa-trash"
							href="${rootURL}${solo}contacts/${contact.id}.html">Details</a></td>
						<td class="text-center"><a id="edit-${contact.sfid}"
							class="fa fa-trash"
							href="${rootURL}${solo}contacts/edit/${contact.id}.html">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
