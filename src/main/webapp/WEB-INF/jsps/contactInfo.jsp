<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Info</title>
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-3.5.1.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/form-validation.js"></script>
</head>
<body>
	<div class="container" align="center">
		<h1>
			<b>Contact Info</b>
		</h1>
		<spring:form action="/register" method="post" modelAttribute="contact"
			id="contactRegistration">
			<table>
				<tr>
					<spring:hidden path="contactId" />
					<td><b><spring:label path="contactName">Name:</spring:label></b></td>
					<td><spring:input path="contactName" /></td>
				</tr>
				<tr>
					<td><b><spring:label path="contactEmail">Email:</spring:label></b></td>
					<td><spring:input path="contactEmail" /></td>
				</tr>
				<tr>
					<td><b><spring:label path="contactNumber">Phno:</spring:label></b></td>
					<td><spring:input path="contactNumber" /></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit">Submit</button></td>
				</tr>
				<c:choose>
					<c:when test="${saveSuccess == true}">
						<tr>
							<td></td>
							<td><b><font color="green"><c:out
											value="Contact Saved Successfully" /></font></b></td>
						</tr>
					</c:when>
					<c:when test="${updateSuccess == true}">
						<tr>
							<td></td>
							<td><b><font color="green"><c:out
											value="Contact Updated Successfully" /></font></b></td>
						</tr>
					</c:when>
				</c:choose>
				<tr>
					<td></td>
					<td><a href="/viewAllContacts">View All Contacts</a></td>
				</tr>
			</table>
		</spring:form>
	</div>
</body>
</html>