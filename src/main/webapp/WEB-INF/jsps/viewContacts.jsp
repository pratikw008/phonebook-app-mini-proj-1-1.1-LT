<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Contacts</title>
</head>
<body>
	<div align="center">
		<h1>All Contacts</h1>
		
		<table border="1">
		<caption align="left"><b><a href="/register">+Add New Contact</a></b></caption>
			<tr>
				<th><b>S.No</b></th>
				<th><b>Name</b></th>
				<th><b>Email</b></th>
				<th><b>Phno</b></th>
				<th><b>Action</b></th>
			</tr>
			<c:choose>
				<c:when test="${!allContacts.isEmpty()}">
					<c:forEach var="contact" items="${allContacts}" varStatus="index">
						<tr>
							<td><c:out value="${index.count}"/></td>
							<td><c:out value="${contact.contactName}"/></td>
							<td><c:out value="${contact.contactEmail}"/></td>
							<td><c:out value="${contact.contactNumber}"/></td>
							<td>
								<a href="/edit?contactId=${contact.contactId}">Edit</a>
								<a href="/delete?contactId=${contact.contactId}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr><td colspan="5"><c:out value="No Contacts" /></td></tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>