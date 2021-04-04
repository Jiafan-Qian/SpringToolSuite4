<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Customer Management</title>
		<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</head>
	
	<body>
		<div class="container">
			<div class="col-md-offset-2-col-md-10">
				<h2	class="text-center">Customer Management</h2>
				<hr />
				<input type="button" value="Add Customer" 
						onclick="window.location.href='showForm';return false;" 
						class="btn btn-primary" />
				<br/><br/>
				<!-- Customer information goes here -->
				<div class="panel panel-info">
					<div class="panel panel-heading">
						<div class="panel panel-title">
							Customer List
						</div>
					</div>
					<div class="panel panel-body">
						<table class="table table-striped table-bordered">
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Mobile No</th>
								<th>Actions</th>
							</tr>
							<!-- loop pver and print the customers -->
							<c:forEach var="tempCustomer" items="${customers}">
								<c:url var="updateLink" value="/customer/updateForm">
									<c:param name="customerId" value="${tempCustomer.id}" />
								</c:url>
								<c:url var="deleteLink" value="/customer/delete">
									<c:param name="customerId" value="${tempCustomer.id}" />
								</c:url>
								<tr>
									<td>${tempCustomer.firstName}</td>
									<td>${tempCustomer.lastName}</td>
									<td>${tempCustomer.mobileNo}</td>
									<td>
										<!-- display the update link -->
										<a href="${updateLink}">Update</a>
										<!-- display the delete link -->
										<a href="${deleteLink}" 
											onclick="if(!(confirm(are you sure))) return false;">Update</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>