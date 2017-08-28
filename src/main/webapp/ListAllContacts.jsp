<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>List Of Contacts</title>
</head>
<body>
	<h3>List Of Contacts</h3>
	<table border="1" width="600">
		<tr>
			<td>Name</td>
			<td>Phone Number</td>
			<td>Email</td>
			<td>Address</td>
			<td colspan="2"><a href="AddNewContact.jsp">New Contact</a></td>
		</tr>

		<c:if test="${ListOfAllContacts.isEmpty()}">
			<tr>
				<td colspan="4">No Contacts found</td>
			</tr>
		</c:if>
		<c:forEach var="contact" items="${ListOfAllContacts}">
			<tr>
				<td><c:out value="${contact.name}" /></td>
				<td><c:out value="${contact.phoneNumber}" /></td>
				<td><c:out value="${contact.email}" /></td>
				<td><c:out value="${contact.address}" /></td>
				<td colspan="2"><a href="ViewContactServlet?id=${contact.id}">View</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>