<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Contact</title>
</head>
<body>
	<h3>Contact</h3>
	<table width="600">

		<tr>
			<td>Name</td>
			<td><c:out value="${contactDetail.name}" /></td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><c:out value="${contactDetail.phoneNumber}" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><c:out value="${contactDetail.email}" /></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><c:out value="${contactDetail.address}" /></td>
		</tr>
		<tr>
			<td colspan="2"><a href="ListAllContactsServlet">Back</a></td>
		</tr>

	</table>
</body>
</html>