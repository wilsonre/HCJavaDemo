<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<title>Members</title>

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
			<div class="title">Member List</div>
		</div>
	</header>
	<div id="content" class="container">

		<div class="center">

			<h1>Listing Members</h1>

		</div>

		<br/> <br/>

		<div id="button">
			<a href="/members/new">Create New Member</a>
		</div>

		<br/> <br/>

		<table class="table">
			<thead>
				<tr>
					<th>Member Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="member" items="${Members}">
					<tr>
						<td><a id="${member.id}"
							href="${rootURL}members/${member.id}.html">${member.firstname} ${member.lastname}</a>
						</td>
						<td><a id="email_${member.id}"
							href="mailto://${member.email}">${member.email}</a></td>
						<td>${member.phone}</td>
						<td class="text-center"><a id="show-${member.id}"
							class="fa fa-trash"
							href="${rootURL}members/${member.id}.html">Details</a></td>
						<td class="text-center"><a id="edit-${member.id}"
							class="fa fa-trash"
							href="${rootURL}${solo}members/edit/${member.id}.html">Edit</a>
						</td>
						<td class="text-center"><a id="edit-${member.id}"
							class="fa fa-trash"
							href="${rootURL}members/enroll/${member.id}.html">Enroll</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
