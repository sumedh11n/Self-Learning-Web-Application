package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mvc.util.DBConnection;
import com.mvc.util.EncryptPassword;

public class ChangePasswordDao {
	
	public String updatePassword(String uname,String old_passwd,String new_passwd,String retype_passwd) {
		
		Connection conn=null;
		ResultSet res=null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
		String old=EncryptPassword.encryption(old_passwd);
		System.out.println(old);
		String result="";
		
		try
		{
			conn=DBConnection.createConnection();
			String query1="select passwd from users where u_name='"+uname+"'";
			String query2="update users set passwd=? where u_name='"+uname+"'";
			
			stmt=conn.createStatement();
			res=stmt.executeQuery(query1);
			res.next();
			if(old.equals(res.getString("passwd")))
			{
				if(new_passwd.equals(retype_passwd))
				{
					String new_ps=EncryptPassword.encryption(new_passwd);
					String retype=EncryptPassword.encryption(retype_passwd);
					
					pstmt=conn.prepareStatement(query2);
					pstmt.setString(1, new_ps);
					int i=pstmt.executeUpdate();
					if(i!=0)
						result="Password updated successfully!";
					else
						result="Something went wrong!";
				}
				else
				{
					result="password and retype password fields do not match";
				}
			}
			else
			{
				result="Current password doesn't match!!";
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return result;
	}

}
