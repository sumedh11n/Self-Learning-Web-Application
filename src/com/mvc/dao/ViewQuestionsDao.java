package com.mvc.dao;

import java.sql.*;
import java.util.ArrayList;

import com.mvc.bean.QuestionBean;
import com.mvc.util.DBConnection;

public class ViewQuestionsDao {
	
	public ArrayList<QuestionBean> getAllQuestions(String uname)
	{
		ArrayList<QuestionBean> Qb= new ArrayList<QuestionBean>();
		Connection conn=null;
		ResultSet res=null;
		Statement stmt=null;
		
		try
		{
			conn=DBConnection.createConnection();
			String query2="select q.ques_id,q.ques_name,q.ch1,q.ch2,q.ch3,q.ch4,q.answer,q.hint,uq.status from questions q,user_questions uq"
					+ " where uq.ques_id=q.ques_id and uq.user_id='"+uname+"'";
			System.out.println(query2);
			stmt=conn.createStatement();
			res=stmt.executeQuery(query2);
			while(res.next())
			{
				QuestionBean QBean=new QuestionBean(res.getInt("ques_id"),res.getString("ques_name"), res.getString("ch1"),
						res.getString("ch2"), res.getString("ch3"), res.getString("ch4"), res.getString("answer"), res.getString("hint"),res.getString("status"));
				Qb.add(QBean);
			}
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return Qb;
	}

}
