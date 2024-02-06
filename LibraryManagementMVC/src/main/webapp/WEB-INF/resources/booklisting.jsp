<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />

<style>

@charset "ISO-8859-1";

table{
margin-left:20px;
margin-right:80px;
}

body {
	font-family: "Roboto", sans-serif;
	font-size: 16px;
	background-color: #f7e6ff;
}

.navbar-text {
	margin-left: 30%;
	font-family: "Hind Siliguri", sans-serif;
	font-size: 2rem;
	font-weight: bold;
}

.navbar-light {
	background-color:   #e6b3ff;
}

.container-fluid {
	padding: 0;
}

.logout-btn {
	float: left;
	display: flex;
	margin-right: 1em;
}

#user-show {
	font-style: italic;
	font-weight: bold;
	opacity: 0.75;
}

.book-listing {
	text-align: center;
}

.book-listing-row {
	width: 100%;
	margin-top: 2rem;
}

.book-listing-text {
	font-family: "Hind Siliguri", sans-serif;
	font-size: 2rem;
	font-weight: bold;
	opacity: 0.75;
}

.add-book-div {
	margin-top: 0.5rem;
	display: flex;
}

.table-container{
  margin-top: 2rem;
}
</style>
<title>Library Management</title>
</head>
<body>
	<nav class="navbar navbar-light">
		<div class="container-fluid">
			<span class="navbar-text"> Library Management</span> <span
				id="user-show"> Hello , ${username} </span>
			<form class="d-flex" action="logout">
				<button class="logout-btn btn btn-primary" type="submit">
					logout</button>
			</form>
		</div>
	</nav>
	<div class="row g-0 book-listing-row">
		<div class="col-sm-6 col-md-8 book-listing">
			<span class="book-listing-text"> Books Listing</span>
		</div>
		<div class="col-6 col-md-4 add-book-div">
			<form class="d-flex" action="addbook">
				<button class="add-book-btn btn btn-primary" type="submit">
					Add Book</button>
			</form>
		</div>
	</div>
	<div class="" style="margin-top: 2rem;">
		<table class="table table-bordered"
			style="">
			<thead style="background-color: rgb(223, 128, 255);">
				<th class="table-heading" style="text-align: center;">Book ID</th>
				<th class="table-heading" style="text-align: center;">Book Name</th>
				<th class="table-heading" style="text-align: center;">Author</th>
				<th class="table-heading" style="text-align: center;">Data
					Added</th>
				<th class="table-heading" style="text-align: center;">Action</th>
			</thead>
			<c:forEach items="${bookList}" var="iter">
				<tbody>
					<tr>
						<td style="text-align: center;">${iter.getBookCode()}</td>
						<td style="text-align: center;">${iter.getBookName() }</td>
						<td style="text-align: center;">${iter.getBookAuthor() }</td>
						<td style="text-align: center;">${iter.getDateTime() }</td>
						<td style="text-align: center;">
							<form action="editview/${iter.getBookCode()}" method="get" style="display: inline">
								<button type="submit" class="btn btn-primary">Edit</button>
							</form> &nbsp;&nbsp;
							<form action="delete/${iter.getBookCode()}"  method="post" style="display: inline">
								<button type="submit" class="btn btn-primary">Delete</button>
							</form>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

</body>

</html>