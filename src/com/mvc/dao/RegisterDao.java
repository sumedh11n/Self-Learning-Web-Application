package com.mvc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;
import com.mvc.util.EncryptPassword;

public class RegisterDao {

	public String registerUser(RegisterBean rb,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String fn = rb.getFname();
		String ln = rb.getLname();
		String un = rb.getUname();
		String passwd = EncryptPassword.encryption(rb.getPasswd());
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			con = DBConnection.createConnection();
			String query1 = "select * from users where u_name= '"+un+"'";
			Statement check = con.createStatement();
			ResultSet resultset = check.executeQuery(query1);
			if(resultset.next()) 
			{
					request.setAttribute("msg", "Username already exists");
					request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
			else 
			{
					String query = "insert into users(f_name,l_name,u_name,passwd) values (?,?,?,?)"; //Insert user details into the table 'USERS'
					preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
					preparedStatement.setString(1, fn);
					preparedStatement.setString(2, ln);
					preparedStatement.setString(3, un);
					preparedStatement.setString(4, passwd);

					int i= preparedStatement.executeUpdate();

					if (i!=0)  //Just to ensure data has been inserted into the database
						return "SUCCESS"; 
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}
}