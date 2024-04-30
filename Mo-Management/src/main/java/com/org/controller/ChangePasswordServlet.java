package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;

@WebServlet("/password")
public class ChangePasswordServlet extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String old = req.getParameter("old");
	String newp = req.getParameter("new");
	String confirm = req.getParameter("confirm");
	int id  =Integer.parseInt(req.getParameter("id")) ;
	 HttpSession session = req.getSession();

	if (newp.equals(confirm)) {
		User user = UserDao.fetchUserById(id);
		if (old.equals(user.getPassword())) {
			UserDao.updatePassword(id, confirm);
				session.setAttribute("msg","Password Updated Successfully");
				resp.sendRedirect("home.jsp");
		} else {
			session.setAttribute("msg","Invalid Old Password");
			resp.sendRedirect("changePassword.jsp");
		}
	}
	else {
			session.setAttribute("msg","New Password and Confirm Password Should be same");
			resp.sendRedirect("changePassword.jsp");
	}
}
}
