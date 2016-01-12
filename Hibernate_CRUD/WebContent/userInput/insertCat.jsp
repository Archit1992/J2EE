<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	
	<link href="<%=request.getContextPath()%>/userInput/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=request.getContextPath()%>/userInput/js/bootstrap.min.js"></script>
	
		
</head>
<body>
	<form action="<%=request.getContextPath()%>/Controller" method="post">
	<table>
		<tr>
			<td style="height:100px" width="100px"><b>First Name :</b></td>
			
			<td><input type="text" class="form-control" ng-model = "yourName" required value="" id="field-2" name="fname" size="20"></td>
		</tr>
		<tr>
			<td style="height:30px" width="100px "><b>Last Name  :</b></td>
			<td><input type="text" class="form-control" required value="" id="field-2" name="lname" size="20"> 
		</tr>
		
		
		
		<tr>	
			<td><input type="hidden" name="flag" value="insert"></td>
			<td style="height:100px" width="100px"><input type="submit" class="btn btn-primary" value="Submit"></td>	
		</tr>
	</table>
		
	</form>
</body>
</html>