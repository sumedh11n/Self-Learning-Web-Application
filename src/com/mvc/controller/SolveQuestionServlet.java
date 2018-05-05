package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.QuestionBean;

@WebServlet("/SolveQuestionServlet")
public class SolveQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SolveQuestionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String question_id=request.getParameter("qid");
		int qid=Integer.parseInt(question_id);
		System.out.println(question_id);
		
		ArrayList<QuestionBean> questions= new ArrayList<QuestionBean>();
		
		questions = (ArrayList<QuestionBean>)request.getSession().getAttribute("all_questions");
		QuestionBean Qb=new QuestionBean();
		int i = -1;
		for(QuestionBean ques:questions)
		{
			i++;
			if(ques.getQues_id()==qid)
			{
				Qb=ques;
			}
		}
		request.getSession().setAttribute("ques", Qb);	
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/solve-question.jsp");
		requestDispatcher.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
