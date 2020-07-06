<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Contacts</title>
<script src="js/jquery-3.5.1.js"></script>
<link href="css/jquery.dataTables.min.css" rel="stylesheet">
<script src="js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	function confirmDelete() {
		  var result = confirm("Are You Sure You Want To Delete Contact?");
		    if (result == true) {
		        return true;
		    }
		    else{
			    return false;
			}
	}
</script>
<script>
	$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>
</head>
<body>
	<div align="center" >
		<h1>All Contacts</h1>

		<table border="1" id="contactTbl">
			<caption align="left">
				<b><a href="/register">+Add New Contact</a></b>
			</caption>
			<thead>
				<tr>
					<th>S.No</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phno</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${!allContacts.isEmpty()}">
						<c:forEach var="contact" items="${allContacts}" varStatus="index">

							<tr>
								<td><c:out value="${index.count}" /></td>
								<td><c:out value="${contact.contactName}" /></td>
								<td><c:out value="${contact.contactEmail}" /></td>
								<td><c:out value="${contact.contactNumber}" /></td>
								<td><a href="/edit?contactId=${contact.contactId}">Edit</a>
									<a href="/delete?contactId=${contact.contactId}"
									onclick="return confirmDelete()">Delete</a></td>
							</tr>

						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5"><c:out value="No Contacts" /></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>