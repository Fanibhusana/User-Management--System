<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User Page</title>
<%@ include file="components/bootstrapCss.jsp"%>
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
						<p class="fs-4 text-center">Add user</p>
						
						<form action="add" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="tel" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="tel" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							
							<button type="submit" class="btn bg-primary text-white col-md-12">Add</button>
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