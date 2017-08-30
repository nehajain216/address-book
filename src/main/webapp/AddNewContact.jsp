<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add New Contact</title>
</head>
<body>
	<h3>Add New Contact</h3>
	<form action="AddNewContactServlet" method="POST">

		<table>
			<tr>
				<td>Name* :</td>
				<td><input type="text" name="name" value="${contact.name}"/>
					<div style="color: #ff0000">
						<c:if test="${not empty errorMessage}">
							<c:out value="${errorMessage}" />
						</c:if>
					</div></td>
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td><input type="text" name="phonenumber" value="${contact.phoneNumber}" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email" value="${contact.email}" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="address" value="${contact.address}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
				<td><a href="ListAllContactsServlet" >Cancel</a></td>
			</tr>
		</table>
	</form>
</body>
</html>