package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.UpdateProfileDao;
import com.mvc.util.DBConnection;


@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String uname=(String) request.getSession().getAttribute("username");
		Connection conn = null;
		try {
			String output = "";
			conn=DBConnection.createConnection();
			Statement statement = conn.createStatement();
			System.out.println("1");
			String query = "select user_id,f_name,l_name from users where u_name='"+uname+"'";
			ResultSet rs = statement.executeQuery(query);
			System.out.println("2");

			rs.next();
				System.out.println("5");
				int user_id = rs.getInt("user_id");
				String f_name = rs.getString("f_name");
				String l_name = rs.getString("l_name");

				//System.out.println(f_name+l_name+u_name);

				output = output + "<div class='field'><label for='pass'>Current Password :&nbsp;</label><input type='password' placeholder='Enter current password' class='login username-field' name='passwd' required/></div><br/>"
						+ "<div class='field'><label for='uid'>User ID :&nbsp;</label><input type='text' class='login username-field' value='"+user_id+"'name='uid' readonly='readonly' required/></div>"
						+ "<div class='field'><label for='fname'>First Name :&nbsp;</label><input type='text' class='login username-field' value='"+f_name+"'name='fname' required/></div>"
						+ "<div class='field'><label for='lname'>Last Name :&nbsp;</label><input type='text' class='login username-field' value='"+l_name+"'name='lname' required/></div>";
			
			rs.close();
			out.println(output);

			System.out.println("4");
			statement.close();

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int user_id=Integer.parseInt(request.getParameter("uid"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String passwd=request.getParameter("passwd");
		
		RegisterBean user=new RegisterBean();
		user.setUser_id(user_id);
		user.setFname(fname);
		user.setLname(lname);
		user.setPasswd(passwd);
		
		UpdateProfileDao dao=new UpdateProfileDao();
		
		String result=dao.saveProfile(user);
		if(result.equalsIgnoreCase("success"))
		{
			request.setAttribute("msg", result);
			request.getRequestDispatcher("update-profile.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", result);
			request.getRequestDispatcher("update-profile.jsp").forward(request, response);
		}
	}

}
