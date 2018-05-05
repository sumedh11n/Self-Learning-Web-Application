package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mvc.bean.QuestionBean;
import com.mvc.util.DBConnection;

public class AnswerFeedbackDao {

	public String submitAnswer(QuestionBean Qb,String user_name)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try
		{
			conn=DBConnection.createConnection();
			String query="update user_questions set status=? where user_id=? and ques_id=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "solved");
			pstmt.setString(2, user_name);
			pstmt.setInt(3, Qb.getQues_id());
			pstmt.executeUpdate();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return "succcess";
		
	}
	
}
