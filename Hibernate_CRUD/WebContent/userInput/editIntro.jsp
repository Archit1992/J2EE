<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	
	<link href="<%=request.getContextPath()%>/userInput/css/bootstrap.min.css" rel="stylesheet">
	<script src="userInput/js/bootstrap.min.js"></script>
	
</head>
<body>


<form action="<%=request.getContextPath()%>/Controller" method="post">

<c:forEach items="${sessionScope.lssearch_edit}" var="r">

<table>
		<tr>
			<td style="height:100px" width="100px">First Name :</td>
			<td><input type="text" name="fname" size="20" class="form-control"  id="field-2" value="${r.firstName}"></td>
		</tr>
		<tr>
			<td style="height:30px" width="100px ">Last Name  :</td>
			<td><input type="text" name="lname" size="20" class="form-control"  id="field-2" value="${r.lastName}"> 
		</tr>
		<tr>	
			<td><input type="hidden" name="flag" value="update">
				<input type="hidden" name="id" value="${r.personId}">
			</td>
			<td style="height:100px" width="100px"><input type="submit" class="btn btn-primary" value="Submit"></td>	
		</tr>
		
	</table>
</c:forEach>

</form>
			
			<%-- <pre>First Name : </pre>
			<input type="text" name="fname" size="20" value="${r.firstName}">

			<pre>Last Name : </pre>
			<input type="text" name="lname" size="20" value="${r.lastName}">

			<input type="hidden" name="flag" value="update">
			<input type="hidden" name="id" value="${r.personId}">

			<br/>
			<br/>
			<br/>
			<input type="submit" name="Submit" value="Submit">

			<table>

			</table>
 --%>		 
</body>
</html>