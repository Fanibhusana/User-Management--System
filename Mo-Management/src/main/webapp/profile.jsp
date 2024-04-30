<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
<%@ include file="components/bootstrapCss.jsp" %>

</head>
<body>

<% User user= (User)session.getAttribute("userObj"); 
if(user==null){
	response.sendRedirect("login.jsp");
} else{
%>
<%@ include file="components/homeNavbar.jsp"%>
<% User u= UserDao.fetchUserById(user.getId()); %>
<h1 style="text-align: center;color:blue">
User name:<%=u.getName() %><br>
User age:<%=u.getAge() %><br>
User mobile:<%=u.getMobile() %><br>
User email:<%=u.getEmail() %><br>
<br> <br> <br>
<a href="update.jsp?id=<%=user.getId()%>" class="text-decoration-none btn btn-primary">Update Profile</a>
</h1>
<%} %>
</body>
</html>
