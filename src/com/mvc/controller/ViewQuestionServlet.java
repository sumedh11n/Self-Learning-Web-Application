package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.QuestionBean;
import com.mvc.dao.ViewQuestionsDao;

@WebServlet("/ViewQuestionServlet")
public class ViewQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		ViewQuestionsDao ques=new ViewQuestionsDao();
		String uname=(String) request.getSession().getAttribute("username");
		
		System.out.print(uname);
		ArrayList<QuestionBean> questions = ques.getAllQuestions(uname);
		request.getSession().setAttribute("all_questions", questions);
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view-question.jsp");
		requestDispatcher.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
