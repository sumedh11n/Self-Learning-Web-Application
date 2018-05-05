package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.util.DBConnection;

public class ClearHistoryDao {
	
	
	public String clearHistory(String uname)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String query="update user_questions set status=? where user_id=?";
		try
		{
			conn=DBConnection.createConnection();
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "unsolved");
			pstmt.setString(2, uname);
			pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}	
		return "success";
	}

}
