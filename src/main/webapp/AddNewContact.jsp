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
				<td>Name :</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td><input type="text" name="phonenumber" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>