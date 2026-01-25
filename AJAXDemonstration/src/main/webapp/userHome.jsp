<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Welcome User </h4>


<p>Welcome,${sessionScope.user}</p>


<a href="logoutservlet">Logout</a>


</body>
</html>