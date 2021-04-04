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
				<div class="panel panel-info">
					<div class="panel panel-heading">
						<div class="panel panel-title">
							Add Customer
						</div>
					</div>
					<div class="panel panel-body">
						<form:form action="saveCustomer" 
									cssClass="form-horizontal" method="post"
									modelAttribute="customers" />
						<!-- need to associate this data with customer id -->
						<form:hidden path="id" />
						<div class="form-group">
							<label for="firstName" class="col-md-3 control-label">FirstName</label>
							<div class="col-md-9">
								<form:input path="firstName" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="lastName" class="col-md-3 control-label">LastName</label>
							<div class="col-md-9">
								<form:input path="lastName" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="mobileNo" class="col-md-3 control-label">MobileNo</label>
							<div class="col-md-9">
								<form:input path="mobileNo" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="form-control">Submit</form:button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>