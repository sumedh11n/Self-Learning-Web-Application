package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("uname");
		String ps = request.getParameter("passwd");
		String cps= request.getParameter("cpasswd");
		String fn = request.getParameter("fname");
		String ln = request.getParameter("lname");
		
		if(ps.equals(cps))
		{
			RegisterBean rb = new RegisterBean();
			rb.setFname(fn);
			rb.setLname(ln);
			rb.setPasswd(ps);
			rb.setCPasswd(cps);
			rb.setUname(un);

			RegisterDao rd = new RegisterDao();

			String userRegistered = rd.registerUser(rb,request,response);

			if(userRegistered.equalsIgnoreCase("Success")) {
				request.setAttribute("msg", "User registered successfully");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "Something went wrong");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("msg", "password and confirm password fields do not match");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		
	}

}
