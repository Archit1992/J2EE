<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="">
		
		<table cellpadding="5" border="1" bordercolor="red">
			<tr>
				<td>Person Id  :</td>
				<td>First Name :</td>
				<td>Last  Name :</td>
				<td>Edit Action</td>
				<td>Delete Action</td>
			</tr>
					<c:forEach items="${sessionScope.lssearch_intro}" var="read">
					
					<tr>
						<td>${read.personId}</td>
						<td>${read.firstName}</td>
						<td>${read.lastName}</td> 
						
						<td><a href="<%=request.getContextPath()%>/Controller?flag=edit&id=${read.personId}">Edit</a></td>	
						<td><a href="<%=request.getContextPath()%>/Controller?flag=delete&id=${read.personId}">Delete</a></td>
					</tr>		
					
					</c:forEach>	
				
		</table>
	</form>
</body>
</html>