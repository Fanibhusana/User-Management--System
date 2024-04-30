<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password Page</title>
<%@ include file="components/bootstrapCss.jsp" %>
</head>
<body>
<%
	User sessionUser = (User) session.getAttribute("userObj");
	if (sessionUser == null) {
		response.sendRedirect("login.jsp");
	} else {
	%>
		<%@ include file="components/homeNavbar.jsp"%>
	
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Update Password</p>
						<%
						String msg = (String) session.getAttribute("msg");
						if (msg != null) {
						%>
						 <p class="text-center text-success fs-4"> <%=msg%></p>
						<%
						session.removeAttribute("msg");
						}
						%>
						<form action="password" method="post">
							
							<div class="mb-3">
								<label class="form-label">Old Password</label> <input
									name="old" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">New Password</label> <input
									name="new" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Confirm  Password</label> <input
									name="confirm" type="password" class="form-control" required>
							</div>
							<input type="hidden" name="id" value="<%=sessionUser.getId()%>">
							<button type="submit" class="btn bg-primary text-white col-md-12">Change Password</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
   
  <%
	}
	%>
</body>
</html>