<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add New Contact</title>
</head>
<body>
	<h3>Add New Contact</h3>
	<form action="AddNewContactServlet" method="POST" >

			Name :	
			<input type="text" name="name"/><br>		
		
			Phone Number :
			<input type="text" name="phonenumber"/>
			
			Email :
			<input type="text" name="email"/>
			
			Address :
			<input type="text" name="address"/>
			
			<input type="submit" value="submit">			
		
		</form>
</body>
</html>