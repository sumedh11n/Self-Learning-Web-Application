package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("in servlet");
		String un = request.getParameter("username");
		String ps = request.getParameter("password");
		
		System.out.println(un);
		System.out.println(ps);
		LoginBean lb=new LoginBean();
		lb.setUname(un);
		lb.setPass(ps);

		
		LoginDao ld=new LoginDao();
		
		String result=ld.authenticateUser(lb);
		HttpSession session=request.getSession();
		
		if (result.equalsIgnoreCase("success"))
		{
			session.setAttribute("username",un);
			request.getRequestDispatcher("userHome.jsp").forward(request, response);
		}
		else 
		{
			request.setAttribute("msg", "Invalid Username & Password");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
			return;
		}

	}

}
