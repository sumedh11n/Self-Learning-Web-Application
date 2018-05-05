package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.ChangePasswordDao;



@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=(String) request.getSession().getAttribute("username");
		String old_passwd=request.getParameter("old_passwd");
		String new_passwd=request.getParameter("new_passwd");
		String retype_passwd=request.getParameter("retype_passwd");
		
		ChangePasswordDao dao=new ChangePasswordDao();
		String result=dao.updatePassword(uname, old_passwd, new_passwd, retype_passwd);
		
		if(result.equalsIgnoreCase("Something went wrong!"))
		{
			request.setAttribute("msg1", result);
			request.getRequestDispatcher("change-password.jsp").forward(request, response);
		}
		else if (result.equalsIgnoreCase("Password and Confirm Password fields do not match"))
		{
			request.setAttribute("msg1", result);
			request.getRequestDispatcher("change-password.jsp").forward(request, response);
		}
		else if(result.equalsIgnoreCase("Current password doesn't match!!"))
		{
			request.setAttribute("msg1", result);
			request.getRequestDispatcher("change-password.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", result);
			request.getSession().invalidate();
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
