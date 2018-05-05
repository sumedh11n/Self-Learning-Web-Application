package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;
import com.mvc.util.EncryptPassword;

public class LoginDao {
	public String authenticateUser(LoginBean loginBean) {
		String userName = loginBean.getUname(); 
		String password = EncryptPassword.encryption(loginBean.getPass());
		
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String userNameDB = "";
		String passwordDB = "";
		try {
			con = DBConnection.createConnection(); 
			statement = con.createStatement();
			String query="select u_name,passwd from users where(u_name='" + userName + "'&&passwd='" + password + "')";
			System.out.println(query);
			resultSet = statement.executeQuery(query); 
			while (resultSet.next())
			{
				userNameDB = resultSet.getString("u_name"); // fetch the values present in database
				passwordDB = resultSet.getString("passwd");
				if (userName.equals(userNameDB) && password.equals(passwordDB)) 
				{
					return "SUCCESS"; 
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials"; // Just returning appropriate message otherwise
	}
}