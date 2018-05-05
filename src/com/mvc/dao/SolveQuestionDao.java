package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mvc.util.DBConnection;

public class SolveQuestionDao {
	
	public String submitAnswer(int ques_id,String answer)
	{
		Connection conn=null;
		PreparedStatement pstmt,pstmt1=null;

		String result=null;
		try
		{
			conn=DBConnection.createConnection();
			String query1="select answer,hint from questions where ques_id='"+ques_id+"'";
			pstmt1=conn.prepareStatement(query1);
			ResultSet res=pstmt1.executeQuery();
			res.next();
			String ans=res.getString("answer");
			String hint=res.getString("hint");
			
			if(answer.equalsIgnoreCase(ans))
			{
				String query="update questions set status=? where ques_id=?";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, "solved");
				pstmt.setInt(2, ques_id);
				pstmt.executeUpdate();
				
				result= "correct";
			}
			else
			{
				result=hint;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return result;
		
	}
	

}
