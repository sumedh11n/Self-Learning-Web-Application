package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.QuestionBean;
import com.mvc.util.DBConnection;

public class AddQuestionDao {
	
	public String addQuestion1(QuestionBean Qb,String uname,HttpServletRequest request, HttpServletResponse response)
	{
		String ques_name=Qb.getQues_name();
		String ch1=Qb.getCh1();
		String ch2=Qb.getCh2();
		String ch3=Qb.getCh3();
		String ch4=Qb.getCh4();
		String ans=Qb.getAnswer();
		String hint=Qb.getHint();
		int i = 0,j=0;
		Connection conn=null;
		PreparedStatement pstmt,pstmt1=null;
		ResultSet res,res1=null;
		Statement stmt=null;
		int ques_id=0;
		try 
		{
			conn=DBConnection.createConnection();
			
			String que="select * from questions where ques_name='"+ques_name+"' ";
			Statement check=conn.createStatement();
			res=check.executeQuery(que);
			if(res.next()) 
			{
				request.setAttribute("msg1", "Question already exists.");
				request.getRequestDispatcher("add-question.jsp").forward(request, response);
			}
			else 
			{
			
			String query="insert into questions (ques_name,ch1,ch2,ch3,ch4,answer,hint,created_by) values (?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, ques_name);
			pstmt.setString(2, ch1);
			pstmt.setString(3, ch2);
			pstmt.setString(4, ch3);
			pstmt.setString(5, ch4);
			pstmt.setString(6, ans);
			pstmt.setString(7, hint);
			pstmt.setString(8, uname);		
			i= pstmt.executeUpdate();
			
			stmt=conn.createStatement();			
			String query2="select ques_id from questions where ques_name='"+ques_name+"' and created_by='"+uname+"'";
			System.out.println(query2);
			res1=stmt.executeQuery(query2);
			res1.next();
			ques_id=res1.getInt("ques_id");
			
			
			String q="select u_name from users";
			ResultSet resultset=stmt.executeQuery(q);
			ArrayList<String> users=new ArrayList<String>();
			while(resultset.next())
			{
				users.add(resultset.getString("u_name"));
			}
			
			System.out.println(users.size());
			String query3="insert into user_questions (user_id,ques_id,status) values (?,?,?)";
			
			int index = -1;
			for(String un:users)
			{
				index++;
				pstmt1=conn.prepareStatement(query3);
				pstmt1.setString(1, un);
				pstmt1.setInt(2, ques_id);
				pstmt1.setString(3, "unsolved");
				j=pstmt1.executeUpdate();
			}		
		
			return "success"; 
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
			return "failure";
	}
	
	public String addQuestion2(QuestionBean Qb,String uname,HttpServletRequest request, HttpServletResponse response)
	{
		String ques_name=Qb.getQues_name();
		String ans=Qb.getAnswer();
		String hint=Qb.getHint();
		int i=0;
		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt,pstmt1=null;
		int ques_id=0,j=0;
		ResultSet res,res1=null;
		
		try 
		{ 
			conn=DBConnection.createConnection();
			
			String que="select * from questions where ques_name='"+ques_name+"'";
			Statement check=conn.createStatement();
			res=check.executeQuery(que);
			if(res.next()) 
			{
				request.setAttribute("msg1", "You have already added this question.");
				request.getRequestDispatcher("add-question.jsp").forward(request, response);
			}
			else 
			{
			
			String query="insert into questions (ques_name,answer,hint,created_by) values (?,?,?,?)";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, ques_name);
			pstmt.setString(2, ans);
			pstmt.setString(3, hint);
			pstmt.setString(4, uname);
			i= pstmt.executeUpdate();
			
			stmt=conn.createStatement();			
			String query2="select ques_id from questions where ques_name='"+ques_name+"' and created_by='"+uname+"'";
			System.out.println(query2);
			res1=stmt.executeQuery(query2);
			res1.next();
			ques_id=res1.getInt("ques_id");
			
			String q="select u_name from users";
			ResultSet resultset=stmt.executeQuery(q);
			ArrayList<String> users=new ArrayList<String>();
			while(resultset.next())
			{
				users.add(resultset.getString("u_name"));
			}
			
			
			String query3="insert into user_questions (user_id,ques_id,status) values (?,?,?)";
			
			int index = -1;
			for(String un:users)
			{
				index++;
				pstmt1=conn.prepareStatement(query3);
				pstmt1.setString(1, un);
				pstmt1.setInt(2, ques_id);
				pstmt1.setString(3, "unsolved");
				j=pstmt1.executeUpdate();
			}
			return "success";
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

			return "failure";
	}

}
