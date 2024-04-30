<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Page</title>
<%@ include file="components/bootstrapCss.jsp" %>
</head>
<body>
<%
	User sessionUser = (User) session.getAttribute("userObj");
	if (sessionUser == null) {
		response.sendRedirect("login.jsp");
	} else {
	
		UserDao.DeleteUser(Integer.parseInt(request.getParameter("id")));
			session.setAttribute("msg","user deleted successfully");
			response.sendRedirect("home.jsp");
	}
	%>
</body>
</html>