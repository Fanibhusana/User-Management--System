<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout Page</title>
<%@ include file="components/bootstrapCss.jsp" %>
</head>
<body>
<%
	User sessionUser = (User) session.getAttribute("userObj");
	if (sessionUser == null) {
		response.sendRedirect("login.jsp");
	} else {
	%>
 <h1 class="fs-3 text-center">
  Are you sure <br>
  you want to Log out<br>
   <a href="yes" class="text-decoration-none btn btn-primary">Yes </a><br>
   <a href="home.jsp" class="text-decoration-none btn btn-primary">No</a>
   </h1>
   
  <%
	}
	%>
</body>
</html>