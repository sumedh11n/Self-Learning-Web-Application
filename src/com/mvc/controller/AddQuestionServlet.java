package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.QuestionBean;
import com.mvc.dao.AddQuestionDao;

@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ques_name=request.getParameter("ques");
		String ch1=request.getParameter("ch1");
		String ch2=request.getParameter("ch2");
		String ch3=request.getParameter("ch3");
		String ch4=request.getParameter("ch4");
		String ans=request.getParameter("ans");
		String hint=request.getParameter("hint");
		String uname=(String) request.getSession().getAttribute("username");
		
		System.out.println(uname+ques_name+ch1+ch2+ch3+ch4+ans+hint);
		QuestionBean Qb=new QuestionBean();
		Qb.setQues_name(ques_name);
		Qb.setCh1(ch1);
		Qb.setCh2(ch2);
		Qb.setCh3(ch3);
		Qb.setCh4(ch4);
		Qb.setAnswer(ans);
		Qb.setHint(hint);
		
		AddQuestionDao dao=new AddQuestionDao();
		String result=dao.addQuestion1(Qb,uname,request,response);
		if(result.equalsIgnoreCase("success"))
		{
			System.out.println("done");
			request.setAttribute("msg1", "Question added successfully");
			request.getRequestDispatcher("add-question.jsp").forward(request, response);
		}
		else
		{
			System.out.println("Failure");
			request.setAttribute("msg1", "Something went wrong");
			request.getRequestDispatcher("add-question.jsp").forward(request, response);
		}
	
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String ques_name1=request.getParameter("ques1");
		String ans1=request.getParameter("ans1");
		String hint1=request.getParameter("hint1");

		String uname=(String) request.getSession().getAttribute("username");
		
		System.out.println(ques_name1+ans1+hint1);
		QuestionBean Qb=new QuestionBean();
		Qb.setQues_name(ques_name1);
		Qb.setAnswer(ans1);
		Qb.setHint(hint1);
		
		AddQuestionDao dao=new AddQuestionDao();
		String result=dao.addQuestion2(Qb,uname,request,response);
		if(result.equalsIgnoreCase("success"))
		{
			System.out.println("done");

			request.setAttribute("msg1", "Question added successfully");
			request.getRequestDispatcher("add-question.jsp").forward(request, response);
		}
		else
		{
			System.out.println("Failure");
			request.setAttribute("msg1", "Something went wrong");
			request.getRequestDispatcher("add-question.jsp").forward(request, response);
		}
		
	}

}
